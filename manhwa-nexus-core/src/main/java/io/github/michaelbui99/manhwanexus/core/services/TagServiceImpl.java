package io.github.michaelbui99.manhwanexus.core.services;

import io.github.michaelbui99.manhwanexus.core.interfaces.repository.TagRepository;
import io.github.michaelbui99.manhwanexus.core.interfaces.service.TagService;
import io.github.michaelbui99.manhwanexus.core.util.MapUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//TODO: Add cache
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<String> getAll() {
        return tagRepository.getAll();
    }

    @Override
    public List<String> getByManhwa(int manhwaId) {
        return tagRepository.getByManhwa(manhwaId);
    }

    @Override
    public String create(String tag) {
        if (tag == null || tag.isBlank() || tag.isEmpty()) {
            throw new IllegalArgumentException("invalid tag");
        }

        return tagRepository.create(tag);
    }

    @Override
    public Optional<String> createIfNotExists(String tag) {
        Map<String, Boolean> registeredTags = MapUtil.fromList(getAll(), true);
        var resolvedTag = tag;
        if (!registeredTags.containsKey(tag)) {
            resolvedTag = tryResolveTag(tag);
        }

        // Assume the tag is something new that needs to be registered if it wasn't resolved properly
        if (!registeredTags.containsKey(resolvedTag)) {
            return Optional.of(create(tag));
        }

        return Optional.empty();
    }

    @Override
    public String tryResolveTag(String tag) {
        return null;
    }
}
