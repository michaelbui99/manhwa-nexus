package io.github.michaelbui99.manhwanexus.core.services;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.*;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;
import io.github.michaelbui99.manhwanexus.core.models.Publisher;
import io.github.michaelbui99.manhwanexus.core.models.Studio;

import java.util.List;
import java.util.Optional;

public class ManhwaServiceImpl implements ManhwaService {
    private final ManhwaRepository manhwaRepository;
    private final CharacterService characterService;
    private final PublisherService publisherService;
    private final StudioService studioService;
    private final GenreService genreService;
    private final TagService tagService;

    public ManhwaServiceImpl(ManhwaRepository manhwaRepository,
                             CharacterService characterService,
                             PublisherService publisherService,
                             StudioService studioService, GenreService genreService, TagService tagService) {
        this.manhwaRepository = manhwaRepository;
        this.characterService = characterService;
        this.publisherService = publisherService;
        this.studioService = studioService;
        this.genreService = genreService;
        this.tagService = tagService;
    }

    @Override
    public Optional<Manhwa> getById(int id) {
        Manhwa existingManhwa = manhwaRepository.getById(id);
        if (existingManhwa == null) {
            return Optional.empty();
        }

        return Optional.of(manhwaRepository.getById(id));
    }

    @Override
    public List<Manhwa> getAll() {
        return manhwaRepository.getAll();
    }

    @Override
    public Manhwa createManhwa(Manhwa manhwa) {
        manhwa.getGenres().forEach(genreService::createIfNotExists);

        manhwa.getTags().forEach(tagService::createIfNotExists);

        // NOTE : (mibui 30-12-2022) In the future when related works is implemented, this might have to be refactored.
        //         Related works indicates that the Manhwa is part of a series, i.e. Characters might already exist
        manhwa.getCharacters().forEach(characterService::create);

        Optional<Publisher> publisher = getPublisher(manhwa);

        Optional<Studio> studio = getStudio(manhwa);

        publisher.ifPresent(manhwa::setPublisher);
        studio.ifPresent(manhwa::setStudio);

        var createdManhwa = manhwaRepository.create(manhwa);

        publisher.ifPresent(p -> publisherService.addPublishedWork(p.getId(), createdManhwa));
        studio.ifPresent(s -> studioService.addListedWork(s.getId(), createdManhwa));

        return createdManhwa;
    }

    @Override
    public boolean deleteManhwa(int id) {
        return false;
    }

    @Override
    public Manhwa updateManhwa(int id, Manhwa manhwa) {
        return null;
    }

    private Optional<Studio> getStudio(Manhwa manhwa) {
        Studio studio;
        if (manhwa.getStudio().isEmpty()) {
            return Optional.empty();
        } else if (!studioService.exists(manhwa.getStudio().get().getName()) || !studioService.exists(manhwa.getStudio().get().getId())) {
            studio = studioService.create(manhwa.getStudio().get());
        } else {
            studio = studioService.getById(manhwa.getStudio().get().getId());
        }
        return Optional.of(studio);
    }

    private Optional<Publisher> getPublisher(Manhwa manhwa) {
        Publisher publisher;

        if (manhwa.getPublisher().isEmpty()) {
            return Optional.empty();
        } else if (!publisherService.exists(manhwa.getPublisher().get().getName()) || !publisherService.exists(manhwa.getPublisher().get().getId())) {
            publisher = publisherService.create(manhwa.getPublisher().get());
        } else {
            publisher = publisherService.getById(manhwa.getPublisher().get().getId());
        }

        return Optional.of(publisher);
    }
}
