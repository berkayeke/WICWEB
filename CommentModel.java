package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Entity.Comment;
import Main.DataBase;

public class CommentModel extends Model {

	public ArrayList<Comment> getAllCommentsByKisiId(int id) {

		ArrayList<Comment> commentList=new ArrayList<Comment>();
		
		
		try {
			PreparedStatement ps = this.db.prepareStatement("Select * from comment where KisiID =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Comment c = new Comment();
				c.setCommentId(rs.getInt("CommentID"));
				c.setKisiId(rs.getInt("KisiID"));
				c.setComment(rs.getString("Comment"));
				commentList.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataBase.baglantiKapa(db);
		}
		return commentList;
	}

	// UpdateComment--------------------------------

	public void UpdateComment(Comment c) {
		try {
			DataBase.baglan();

			PreparedStatement ps = this.db.prepareStatement("Update Comment KisiID=?, Comment=? where CommentID =?");
			ps.setInt(1, c.getKisiId());
			ps.setString(2, c.getComment());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
	}

	// DeleteComment--------------------------------

	public void DeleteComment(int id) {

		try {

			PreparedStatement ps = this.db.prepareStatement("Delete from comment where CommentID =?");
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
	}

	// CreateComment--------------------------------

	public void CreateComment(Comment c) {

		try {

			PreparedStatement ps = this.db.prepareStatement("insert into comment(KisiId,Comment) values(?,?)");

			ps.setInt(1, c.getKisiId());
			ps.setString(2, c.getComment());
			ps.executeUpdate();
			this.db.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBase.baglantiKapa(this.db);
		}
	}
}
