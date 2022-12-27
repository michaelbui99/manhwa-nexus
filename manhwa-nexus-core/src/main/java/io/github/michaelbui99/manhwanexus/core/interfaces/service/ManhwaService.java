package io.github.michaelbui99.manhwanexus.core.interfaces.service;

import io.github.michaelbui99.manhwanexus.core.models.Manhwa;

import java.util.List;

public interface ManhwaService {
    /**
     * Get Manhwa by id.
     *
     * @return Single Manhwa with the provided id
     * @throws io.github.michaelbui99.manhwanexus.core.exceptions.ManhwaNotFoundException if no Manhwa with the
     *                                                                                    provided id exists
     **/
    Manhwa getById(int id);

    /**
     * Returns all Manhwas stored in the system
     *
     * @return List of all Manhwa
     */
    List<Manhwa> getAll();

    /**
     * Creates a new Manhwa in the system.
     */
    Manhwa createManhwa(Manhwa manhwa);

    /**
     * Deletes a Manhwa from the system including Characters. This will not delete models related to the production
     * of the Manhwa including Studio, Staff and Publisher
     *
     * @return true if deleted successfully, else false
     */
    boolean deleteManhwa(int id);

    /**
     * Updates state of Manhwa with id of <code>id</code> to match <code>manhwa</code>
     *
     * @param id     internal id of the Manhwa to update
     * @param manhwa Updated state of the Manhwa
     * @return The updated Manhwa
     */
    Manhwa updateManhwa(int id, Manhwa manhwa);
}
