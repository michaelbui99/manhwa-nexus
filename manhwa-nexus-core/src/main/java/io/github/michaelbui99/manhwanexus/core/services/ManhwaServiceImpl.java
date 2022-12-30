package io.github.michaelbui99.manhwanexus.core.services;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.ManhwaRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.*;
import io.github.michaelbui99.manhwanexus.core.models.Manhwa;
import io.github.michaelbui99.manhwanexus.core.models.Publisher;
import io.github.michaelbui99.manhwanexus.core.models.Studio;
import io.github.michaelbui99.manhwanexus.core.util.MapUtil;

import java.util.List;
import java.util.Map;

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
    public Manhwa getById(int id) {
        return manhwaRepository.getById(id);
    }

    @Override
    public List<Manhwa> getAll() {
        return manhwaRepository.getAll();
    }

    @Override
    public Manhwa createManhwa(Manhwa manhwa) {
        Map<String, Boolean> registeredGenres = MapUtil.fromList(genreService.getAll(), true);
        manhwa.getGenres().forEach(genre -> createGenreIfNotExists(registeredGenres, genre));

        Map<String, Boolean> registeredTags = MapUtil.fromList(tagService.getAll(), true);
        manhwa.getTags().forEach(tag -> createTagIfNotExists(registeredTags, tag));

        // NOTE : (mibui 30-12-2022) In the future when related works is implemented, this might have to be refactored.
        //         Related works indicates that the Manhwa is part of a series, i.e. Characters might already exist
        manhwa.getCharacters().forEach(characterService::create);

        Publisher publisher = getPublisher(manhwa);

        Studio studio = getStudio(manhwa);

        var createdManhwa = manhwaRepository.create(manhwa);

        if (publisher != null) {
            publisherService.addPublishedWork(publisher.getId(), createdManhwa);
        }

        if (studio != null) {
            studioService.addListedWork(studio.getId(), createdManhwa);
        }

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

    private Studio getStudio(Manhwa manhwa) {
        Studio studio;
        if (manhwa.getStudio() == null) {
            studio = null;
        } else if (!studioService.exists(manhwa.getStudio().getName()) || !studioService.exists(manhwa.getStudio().getId())) {
            studio = studioService.create(manhwa.getStudio());
        } else {
            studio = studioService.getById(manhwa.getStudio().getId());
        }
        return studio;
    }

    private Publisher getPublisher(Manhwa manhwa) {
        Publisher publisher;
        if (manhwa.getPublisher() == null) {
            publisher = null;
        } else if (!publisherService.exists(manhwa.getPublisher().getName()) || !publisherService.exists(manhwa.getPublisher().getId())) {
            publisher = publisherService.create(manhwa.getPublisher());
        } else {
            publisher = publisherService.getById(manhwa.getPublisher().getId());
        }
        return publisher;
    }

    private void createTagIfNotExists(Map<String, Boolean> registeredTags, String tag) {
        var resolvedTag = tag;
        if (!registeredTags.containsKey(tag)) {
            resolvedTag = tagService.tryResolveTag(tag);
        }

        // Assume the tag is something new that needs to be registered if it wasn't resolved properly
        if (!registeredTags.containsKey(resolvedTag)) {
            tagService.create(tag);
        }
    }

    private void createGenreIfNotExists(Map<String, Boolean> registeredGenres, String genre) {
        var resolvedGenre = genre;
        if (!registeredGenres.containsKey(genre)) {
            resolvedGenre = genreService.tryResolveGenre(genre);
        }

        // Assume the genre is something new that needs to be registered if it wasn't resolved properly
        if (!registeredGenres.containsKey(resolvedGenre)) {
            genreService.create(genre);
        }
    }

}
