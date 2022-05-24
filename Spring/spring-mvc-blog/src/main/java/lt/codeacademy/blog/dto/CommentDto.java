package lt.codeacademy.blog.dto;

public class CommentDto {
    private String comment;
    private Long commentId;
    private Long postId;
    private Long blogUserId;

    public CommentDto() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getBlogUserId() {
        return blogUserId;
    }

    public void setBlogUserId(Long blogUserId) {
        this.blogUserId = blogUserId;
    }
}
