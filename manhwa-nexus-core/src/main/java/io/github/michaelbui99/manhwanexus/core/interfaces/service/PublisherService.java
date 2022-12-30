package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import io.github.michaelbui99.manhwanexus.core.models.Manhwa;
import io.github.michaelbui99.manhwanexus.core.models.Publisher;

public interface PublisherService {
    Publisher create(Publisher publisher);

    Publisher getById(int id);

    boolean exists(int id);

    boolean exists(String name);

    Publisher addPublishedWork(int publisherId, Manhwa manhwa);
}
