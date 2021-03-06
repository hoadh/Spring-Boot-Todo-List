package my.app.has.musicplayer.services;

import my.app.has.musicplayer.models.Song;
import my.app.has.musicplayer.repositories.SongRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class SongServiceTest {

    private SongRepository songRepository = Mockito.mock(SongRepository.class);
    private ISongService songService = new SongService(songRepository);

    public SongServiceTest() {
    }

    @BeforeEach
    void init() {
        Song song = new Song();
        song.setId(1L);
        song.setName("Hãy trao cho anh");
        song.setDescription("Phát hành 2019");

        doReturn(Optional.of(song)).when(songRepository).findById(1L);
        doReturn(song).when(songRepository).getOne(1L);
    }

//    @Test
//    void findAll() {
//    }

    @Test
    public void findById() {
        Song song = songService.findById(1L);

        Assertions.assertThat(song).isNotNull();
        Assertions.assertThat(song.getId()).isEqualTo(1L);
        Assertions.assertThat(song.getName()).isEqualTo("Hãy trao cho anh");
        Assertions.assertThat(song.getDescription()).isEqualTo("Phát hành 2019");
    }

//    @Test
//    void save() {
//    }
//
//    @Test
//    void delete() {
//    }
}