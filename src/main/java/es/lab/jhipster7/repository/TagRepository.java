package es.lab.jhipster7.repository;

import es.lab.jhipster7.domain.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data SQL reactive repository for the Tag entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TagRepository extends R2dbcRepository<Tag, Long>, TagRepositoryInternal {
    Flux<Tag> findAllBy(Pageable pageable);

    // just to avoid having unambigous methods
    @Override
    Flux<Tag> findAll();

    @Override
    Mono<Tag> findById(Long id);

    @Override
    <S extends Tag> Mono<S> save(S entity);
}

interface TagRepositoryInternal {
    <S extends Tag> Mono<S> insert(S entity);
    <S extends Tag> Mono<S> save(S entity);
    Mono<Integer> update(Tag entity);

    Flux<Tag> findAll();
    Mono<Tag> findById(Long id);
    Flux<Tag> findAllBy(Pageable pageable);
    Flux<Tag> findAllBy(Pageable pageable, Criteria criteria);
}
