import com.api.Model.Post;
import com.api.Model.Song;
import com.api.Repository.User.UserAction;
import com.api.Repository.User.UserData;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class UserActionTests {
    private static final int TEST_ID = 331;
    private static final int POST_ID = 332;

    @Test
    public void testLike() {
        boolean success = false;
        try {
            success = UserAction.changePostLike(TEST_ID, POST_ID, 1);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assert (success);
    }

    @Test
    public void testFetchLike() {
        try {
            List<Post> likes = UserData.getLikes(TEST_ID);
            Post testPost = new Post(POST_ID, new Song(), "");
            assert(likes.contains(testPost));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveLike() {
        try {
            UserAction.changePostLike(TEST_ID, POST_ID, 0);
            List<Post> likes = UserData.getLikes(TEST_ID);
            Post testPost = new Post(POST_ID, new Song(), "");
            assert(!likes.contains(testPost));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFavorite() {
        boolean success = false;
        try {
            success = UserAction.changePostFavourite(TEST_ID, POST_ID, 1);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        assert (success);
    }

    @Test
    public void testFetchFavorite() {
        try {
            List<Post> favorites = UserData.getFavourites(TEST_ID);
            Post testPost = new Post(POST_ID, new Song(), "");
            assert(favorites.contains(testPost));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveFavourite() {
        try {
            UserAction.changePostFavourite(TEST_ID, POST_ID, 0);
            List<Post> favourites = UserData.getFavourites(TEST_ID);
            Post testPost = new Post(POST_ID, new Song(), "");
            assert(!favourites.contains(testPost));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDislikeFunctionality() {
        try {
            Assert.assertTrue(UserAction.changePostDislike(TEST_ID, POST_ID, 1));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFetchDislikes() {
        try {
            List<Post> dislikedPosts = UserData.getDislikes(TEST_ID);
            Post testPost = new Post(POST_ID, new Song(), "");
            assert(dislikedPosts.contains(testPost));
        } catch (ClassNotFoundException | InstantiationException | SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveDislike() {
        try {
            UserAction.changePostDislike(TEST_ID, POST_ID, 0);
            List<Post> dislikes = UserData.getDislikes(TEST_ID);
            Post testPost = new Post(POST_ID, new Song(), "");
            assert(!dislikes.contains(testPost));
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
