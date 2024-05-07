package com.wilmfilm.app.service;

import com.wilmfilm.app.service.dto.WatchedDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.wilmfilm.app.domain.Watched}.
 */
public interface WatchedService {
    /**
     * Save a watched.
     *
     * @param watchedDTO the entity to save.
     * @return the persisted entity.
     */
    WatchedDTO save(WatchedDTO watchedDTO);

    /**
     * Updates a watched.
     *
     * @param watchedDTO the entity to update.
     * @return the persisted entity.
     */
    WatchedDTO update(WatchedDTO watchedDTO);

    /**
     * Partially updates a watched.
     *
     * @param watchedDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<WatchedDTO> partialUpdate(WatchedDTO watchedDTO);

    /**
     * Get all the watcheds.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<WatchedDTO> findAll(Pageable pageable);

    /**
     * Get the "id" watched.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<WatchedDTO> findOne(Long id);

    /**
     * Delete the "id" watched.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
