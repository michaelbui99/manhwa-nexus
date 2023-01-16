package io.github.michaelbui99.manhwanexus.core.services;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ManhwaServiceTest {
    private ManhwaRepository manhwaRepositoryMock;
    private CharacterService characterServiceMock;
    private PublisherService publisherServiceMock;
    private StudioService studioServiceMock;
    private GenreService genreServiceMock;
    private TagService tagServiceMock;

    private ManhwaService manhwaService;

    @BeforeEach
    public void setUp() {
        manhwaRepositoryMock = mock(ManhwaRepository.class);
        characterServiceMock = mock(CharacterService.class);
        publisherServiceMock = mock(PublisherService.class);
        studioServiceMock = mock(StudioService.class);
        genreServiceMock = mock(GenreService.class);
        tagServiceMock = mock(TagService.class);

        manhwaService = new ManhwaServiceImpl(manhwaRepositoryMock, characterServiceMock, publisherServiceMock, studioServiceMock, genreServiceMock, tagServiceMock);
    }
}