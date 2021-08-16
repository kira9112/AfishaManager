package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

class AfishaManagerTestWithMockito {

    @Mock
    private AfishaRepository repository;

    @InjectMocks
    private AfishaManager manager = new AfishaManager(repository);

    Movie first = new Movie(1, "urlБладшот", "Бладшот", ",боевик", false);
    Movie second = new Movie(2, "urlВперед", "Вперед", "мультфильм",false);
    Movie third = new Movie(3, "urlОтельБелград ", "Отель Белгард","комедия",false);
    Movie fourth = new Movie(4, "urlДжентельмены", "Джентельмены", "боевик",false);
    Movie fifth = new Movie(5, "urlЧеловек-невидимка", "Человек-невидимка", "ужасы",false);
    Movie sixth = new Movie(6, "urlТролли.Мировой тур", "Тролли.Мировой тур", "мультфильм",true);
    Movie seventh = new Movie(7, "urlНомерОдин", "Номер Один", "комедия",true);
    Movie eighth = new Movie (8, "urlГлавный Герой", "Главный Герой" , "комедия", false);
    Movie ninth= new Movie (9, "urlВремя", "Время" , "ужасы", true);
    Movie tenth= new Movie(10, "urlЛука", "Лука","мультфильм", false);
    Movie eleventh= new Movie(11, "urlХищники", "Хищники","комедия", false);
    Movie twelve= new Movie(12, "urlТвинПикс", "Твин Пикс","триллер", false);


    @Test
    void showDefaultAfisha() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void showDefaultAfishaManyFilms() {
        Movie[] returned = new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{twelve,eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth,third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void showDefaultAfishaFewMovies() {
        Movie[] returned = new Movie[]{first, second, fourth, fifth, sixth, seventh};
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, second,first};

        assertArrayEquals(expected, actual);
    }
}