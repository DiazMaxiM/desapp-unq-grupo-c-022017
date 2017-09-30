package repositories;

import java.util.List;
import java.util.Set;

import model.Post;

public interface PostRepository {

    Integer getcount(String tag);

    Set<String> getTags();

    List<Post> getPosts(int from, int number, String tag);

    List<Post> getPosts(String author);

}