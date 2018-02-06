package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.RNS_SECTOR_MASTER;

import io.github.jhipster.application.repository.RNS_SECTOR_MASTERRepository;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing RNS_SECTOR_MASTER.
 */
@RestController
@RequestMapping("/api")
public class RNS_SECTOR_MASTERResource {

    private final Logger log = LoggerFactory.getLogger(RNS_SECTOR_MASTERResource.class);

    private static final String ENTITY_NAME = "rNS_SECTOR_MASTER";

    private final RNS_SECTOR_MASTERRepository rNS_SECTOR_MASTERRepository;

    public RNS_SECTOR_MASTERResource(RNS_SECTOR_MASTERRepository rNS_SECTOR_MASTERRepository) {
        this.rNS_SECTOR_MASTERRepository = rNS_SECTOR_MASTERRepository;
    }

    /**
     * POST  /rns-sector-masters : Create a new rNS_SECTOR_MASTER.
     *
     * @param rNS_SECTOR_MASTER the rNS_SECTOR_MASTER to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rNS_SECTOR_MASTER, or with status 400 (Bad Request) if the rNS_SECTOR_MASTER has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rns-sector-masters")
    @Timed
    public ResponseEntity<RNS_SECTOR_MASTER> createRNS_SECTOR_MASTER(@RequestBody RNS_SECTOR_MASTER rNS_SECTOR_MASTER) throws URISyntaxException {
        log.debug("REST request to save RNS_SECTOR_MASTER : {}", rNS_SECTOR_MASTER);
        if (rNS_SECTOR_MASTER.getId() != null) {
            throw new BadRequestAlertException("A new rNS_SECTOR_MASTER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RNS_SECTOR_MASTER result = rNS_SECTOR_MASTERRepository.save(rNS_SECTOR_MASTER);
        return ResponseEntity.created(new URI("/api/rns-sector-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rns-sector-masters : Updates an existing rNS_SECTOR_MASTER.
     *
     * @param rNS_SECTOR_MASTER the rNS_SECTOR_MASTER to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rNS_SECTOR_MASTER,
     * or with status 400 (Bad Request) if the rNS_SECTOR_MASTER is not valid,
     * or with status 500 (Internal Server Error) if the rNS_SECTOR_MASTER couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rns-sector-masters")
    @Timed
    public ResponseEntity<RNS_SECTOR_MASTER> updateRNS_SECTOR_MASTER(@RequestBody RNS_SECTOR_MASTER rNS_SECTOR_MASTER) throws URISyntaxException {
        log.debug("REST request to update RNS_SECTOR_MASTER : {}", rNS_SECTOR_MASTER);
        if (rNS_SECTOR_MASTER.getId() == null) {
            return createRNS_SECTOR_MASTER(rNS_SECTOR_MASTER);
        }
        RNS_SECTOR_MASTER result = rNS_SECTOR_MASTERRepository.save(rNS_SECTOR_MASTER);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rNS_SECTOR_MASTER.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rns-sector-masters : get all the rNS_SECTOR_MASTERS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rNS_SECTOR_MASTERS in body
     */
    @GetMapping("/rns-sector-masters")
    @Timed
    public List<RNS_SECTOR_MASTER> getAllRNS_SECTOR_MASTERS() {
        log.debug("REST request to get all RNS_SECTOR_MASTERS");
        return rNS_SECTOR_MASTERRepository.findAll();
        }

    /**
     * GET  /rns-sector-masters/:id : get the "id" rNS_SECTOR_MASTER.
     *
     * @param id the id of the rNS_SECTOR_MASTER to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rNS_SECTOR_MASTER, or with status 404 (Not Found)
     */
    @GetMapping("/rns-sector-masters/{id}")
    @Timed
    public ResponseEntity<RNS_SECTOR_MASTER> getRNS_SECTOR_MASTER(@PathVariable Long id) {
        log.debug("REST request to get RNS_SECTOR_MASTER : {}", id);
        RNS_SECTOR_MASTER rNS_SECTOR_MASTER = rNS_SECTOR_MASTERRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rNS_SECTOR_MASTER));
    }

    /**
     * DELETE  /rns-sector-masters/:id : delete the "id" rNS_SECTOR_MASTER.
     *
     * @param id the id of the rNS_SECTOR_MASTER to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rns-sector-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteRNS_SECTOR_MASTER(@PathVariable Long id) {
        log.debug("REST request to delete RNS_SECTOR_MASTER : {}", id);
        rNS_SECTOR_MASTERRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
