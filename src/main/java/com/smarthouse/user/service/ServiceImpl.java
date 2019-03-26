package com.smarthouse.user.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class ServiceImpl<Item, Key> implements Service<Item, Key> {

    private final JpaRepository<Item, Key> repository;

    public ServiceImpl(final JpaRepository<Item, Key> repository) {
        this.repository = repository;
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Item> getById(final Key id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final Item item) {
        repository.delete(item);
    }

    @Override
    public void deleteById(final Key id) {
        repository.deleteById(id);
    }

    @Override
    public Item save(final Item item) {
        return repository.save(item);
    }
}
