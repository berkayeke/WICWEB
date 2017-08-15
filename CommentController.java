package Controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Entity.Comment;
import Entity.Kisi;
import Model.CommentModel;
import Model.KisiModel;

public class CommentController extends Controller {

	public boolean isCommentValid(String comment) {

		
		
		final String COMMENT_PATTERN = "[A-Za-z0-9,;'.\"\\s\\.ðüþiöçuýÐÜÞÝÖÇI]*{10,}[.!?]";
		Pattern pattern = Pattern.compile(COMMENT_PATTERN);
		Matcher matcher = pattern.matcher(comment);
		
		System.out.println(comment + matcher.matches());
		return matcher.matches();
		
		
//		return comment.length()>10;
	}

	public ArrayList<Comment> getAllCommentsByKisiId(int id) {

		ArrayList<Comment> commentList = new ArrayList<Comment>();
		Comment c = new Comment();
		CommentModel cm = new CommentModel();
		KisiModel km = new KisiModel();
		if (id == 0) {
			System.out.println("Hata");
		} else {
			commentList = cm.getAllCommentsByKisiId(id);
		}

		return commentList;
	}

	public void record(Comment c) {

		CommentModel cm = new CommentModel();
		if (isCommentValid(c.getComment())) {
			cm.CreateComment(c);
		}
	}
}
