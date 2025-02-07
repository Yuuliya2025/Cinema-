import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    void setup() {
        manager = new MovieManager(); // Используем конструктор по умолчанию
    }


    @Test
    public void test() {
        MovieManager manager = new MovieManager();
        String[] actual = manager.findAll();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Secondtest() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        String[] actual = manager.findAll();
        String[] expected = {"Film 1"};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void Thirdtest() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        String[] actual = manager.findAll();
        String[] expected = {"Film 1","Film 2",  "Film 3"};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void testFindLastWithDefaultLimit() {
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        manager.addMovie("Film 5");
        manager.addMovie("Film 6");
        String[] actual = manager.findLast();
        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithCustomLimit() {
        manager = new MovieManager(3); // Создаем менеджер с лимитом 3
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        String[] actual = manager.findLast();
        String[] expected = {"Film 4", "Film 3", "Film 2"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWhenLessThanLimit() {
        manager = new MovieManager(10); // Лимит больше количества фильмов
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        String[] actual = manager.findLast();
        String[] expected = {"Film 2", "Film 1"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastEmptyManager() {
        String[] actual = manager.findLast();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}





