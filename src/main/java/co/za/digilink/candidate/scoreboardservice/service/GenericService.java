package co.za.digilink.candidate.scoreboardservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public abstract class GenericService<R extends JpaRepository, ID, T> {
    private final R repository;

    public GenericService(R repository) {
        this.repository = repository;
    }

    public T getById(ID id) throws NoSuchElementException {
        return (T) this.repository.findById(id).get();
    }

    public T persist(T object) {
        return (T) this.repository.save(object);
    }

    public List<T> getAll() {
        return this.repository.findAll();
    }

    public T edit(ID id, T object) throws NoSuchElementException {
        try {
            final Optional<T> optionalT = repository.findById(id);
            final Object edited = optionalT.get();
            //TODO:Implement Mapper
        } catch (NoSuchElementException elementException) {
            throw elementException;
        }
        return null;
    }

    public List<T> createAll(Set<T> object) {
        return repository.saveAllAndFlush(object);
    }
}
