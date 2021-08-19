package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    AfishaRepository repository = new AfishaRepository();

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

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
        repository.save(eleventh);
        repository.save(twelve);
    }

    @Test
    void removeById() {
        repository.removeById(3);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh, twelve};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        repository.removeAll();

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Movie actual = repository.findById(3);
        Movie expected = third;

        assertEquals(expected, actual);
    }
}