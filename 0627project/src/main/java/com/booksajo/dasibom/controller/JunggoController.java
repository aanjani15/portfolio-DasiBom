package com.booksajo.dasibom.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.booksajo.dasibom.service.UsedBookService;
import com.booksajo.dasibom.vo.UsedBookVO;



@Controller
public class JunggoController {

    @Autowired
    private UsedBookService usedBookService;

    @RequestMapping("/junggo_list.do")
    public String showListPage(@RequestParam(defaultValue = "1") int page, Model model) {
        int pageSize = 10;
        int totalCount = usedBookService.getUsedBookCount();
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        if (page < 1) page = 1;
        if (page > totalPages) page = totalPages;

        int startRow = (page - 1) * pageSize + 1;
        int endRow = page * pageSize;

        ArrayList<UsedBookVO> list = usedBookService.getUsedBooksByPage(startRow, endRow);

     // ?��?�� ?��미�? 경로 �? �? 번째�? ?��?��?��?��?���? ?���?,
        // ?���? 경로 리스?���? VO?�� ?��?���? 추�??��?�� 방식
        for (UsedBookVO post : list) {
            String fullPath = post.getImage_path();
            if (fullPath != null && !fullPath.trim().isEmpty()) {
                String[] paths = fullPath.split(";");
                post.setImage_path(paths[0].trim()); // ?��?��?��?�� �? 번째 ?��미�? ?��?��

                // 리스?��로도 ?��미�? 경로�? ?��?��?���? ?��?���? UsedBookVO?�� List<String> imageList ?��?�� 추�? ?��?��
                List<String> imageList = new ArrayList<String>();
                for (String path : paths) {
                    if (!path.trim().isEmpty()) {
                        imageList.add(path.trim());
                    }
                }
                post.setImagePathList(imageList); // VO?�� setter 만들?��?�� ?��
            }
            Date postDate = post.getPost_date();
            if (postDate != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
                String formattedDate = "?��?��?��: " + sdf.format(postDate);
                model.addAttribute("formattedDate", formattedDate);
            }
        }

        model.addAttribute("usedBookList", list);
        
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("hasPrev", page > 1);
        model.addAttribute("hasNext", page < totalPages);
        model.addAttribute("prevPage", page - 1);
        model.addAttribute("nextPage", page + 1);

        return "junggo_list";
    }


    @RequestMapping("/junggo_view.do")
    public String showViewPage(@RequestParam("post_id") int post_id, Model model) {
        UsedBookVO book = usedBookService.getUsedBook(post_id);

        // �? ?��미�? 경로 분리?��?�� 리스?��?�� ???��
        if (book.getImage_path() != null && !book.getImage_path().isEmpty()) {
            String[] paths = book.getImage_path().split(";");
            List<String> imageList = new ArrayList<>();
            for (String path : paths) {
                if (!path.trim().isEmpty()) {
                    imageList.add(path.trim());
                }
            }
            book.setImagePathList(imageList); // VO?�� setter ?��?��
        }

        model.addAttribute("book", book);

        // ?���? ?���?
        Date postDate = book.getPost_date();
        if (postDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm");
            String formattedDate = "?��?��?��: " + sdf.format(postDate);
            model.addAttribute("formattedDate", formattedDate);
        }

        return "junggo_view";
    }

    @GetMapping("/junggo_write.do")
    public String showWritePage() {
        return "junggo_write";
    }

    @PostMapping("/junggo_write.do")
    public String submitWrite(
        @ModelAttribute UsedBookVO usedBook,
        @RequestParam(value = "images", required = false) MultipartFile[] images,
        HttpServletRequest request
    ) {
        usedBook.setPost_date(new Date());

        if (images != null && images.length > 0) {
            String uploadDir = request.getServletContext().getRealPath("/resources/uploads/");
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) uploadPath.mkdirs();

            StringBuilder imagePaths = new StringBuilder();

            for (MultipartFile image : images) {
                if (!image.isEmpty()) {
                    String originalFilename = image.getOriginalFilename();
                    String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
                    String newFileName = UUID.randomUUID().toString() + extension;

                    File dest = new File(uploadPath, newFileName);
                    try {
                        image.transferTo(dest);
                        if (imagePaths.length() > 0) imagePaths.append(";");
                        imagePaths.append("/resources/uploads/").append(newFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            usedBook.setImage_path(imagePaths.toString());
        }

        usedBookService.insertUsedBook(usedBook);

        return "redirect:/junggo_list.do";
    }
    //update
    
    @GetMapping("/junggo_update.do")
    public String showUpdateForm(@RequestParam("post_id") int post_id, Model model) {
    	UsedBookVO book = usedBookService.getUsedBook(post_id);
    	model.addAttribute("book", book);
    	return "/junggo_update";
    }
    
    @PostMapping("/junggo_update.do")
    public String updateUsedBook(@ModelAttribute UsedBookVO book,
                                 @RequestParam(value = "images", required = false) MultipartFile[] imageFiles,
                                 HttpServletRequest request) {
        // 1. ?��미�? ?��?�� 처리 (복수)
        List<String> savedImagePaths = new ArrayList<>();

        if (imageFiles != null) {
            String uploadDir = request.getServletContext().getRealPath("/resources/upload");
            for (MultipartFile imageFile : imageFiles) {
                if (!imageFile.isEmpty()) {
                    String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
                    File dest = new File(uploadDir, fileName);
                    try {
                        imageFile.transferTo(dest);
                        savedImagePaths.add("/resources/upload/" + fileName); // DB ???��?�� 경로
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // 2. VO?�� ?��미�? 경로 리스?�� ?��?��
        if (!savedImagePaths.isEmpty()) {
            book.setImagePathList(savedImagePaths);
        }

        // 3. 게시�? ?��?�� 처리
        usedBookService.updateUsedBook(book);

        return "redirect:/junggo_view.do?post_id=" + book.getPost_id();
    }

    
    @PostMapping("/junggo_delete.do")
    public String delectBook(@RequestParam("post_id") int postId) {
    	usedBookService.deleteUsedBook(postId);
    	return "redirect:/junggo_list.do";
    }
}
