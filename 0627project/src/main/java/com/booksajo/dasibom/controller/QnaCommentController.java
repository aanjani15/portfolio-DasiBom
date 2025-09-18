package com.booksajo.dasibom.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.booksajo.dasibom.service.CommentService;
import com.booksajo.dasibom.vo.CommentVO;


@Controller
public class QnaCommentController {

	@Resource(name = "CommentService")
	private CommentService commentService;

	// QnA ��� �ۼ� (�Ϲ� ��� / ���� ����)
	@RequestMapping("/writeQnaComment.do")
	public String writeQnaComment(@ModelAttribute CommentVO commentVO, RedirectAttributes redirectAttributes) {
		if (commentVO.getParent_comment_id() == 0) {
			commentService.writeComment(commentVO); // �Ϲ� ���
		} else {
			commentService.writeReplyComment(commentVO); // ����
		}
		redirectAttributes.addAttribute("post_id", commentVO.getPost_id());
		return "redirect:/showDetailQna.do";
	}

	// QnA ��� ����
	@RequestMapping("/deleteQnaComment.do")
	public String deleteQnaComment(@RequestParam int comment_id, @RequestParam int post_id,
			RedirectAttributes redirectAttributes) {
		try {
			boolean deleted = commentService.deleteComment(comment_id);
			if (deleted) {
				redirectAttributes.addFlashAttribute("message", "����� �����߽��ϴ�.");
			} else {
				redirectAttributes.addFlashAttribute("message", "��� ������ �����߽��ϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "�ý��� ������ �߻��߽��ϴ�.");
		}
		redirectAttributes.addAttribute("post_id", post_id);
		return "redirect:/showDetailQna.do";
	}

	// QnA ��� ����
	@RequestMapping("/updateQnaComment.do")
	public String updateQnaComment(@RequestParam int comment_id, @RequestParam int post_id,
			@RequestParam("edited_content") String editedContent, RedirectAttributes redirectAttributes) {

		String normalizedContent = editedContent.replace("\r\n", "\n");

		CommentVO comment = new CommentVO();
		comment.setComment_id(comment_id);
		comment.setComment_contents(normalizedContent);

		commentService.updateComment(comment);

		redirectAttributes.addAttribute("post_id", post_id);
		return "redirect:/showDetailQna.do";
	}
}