package oop.practice;

import java.util.List;

public record Universe(
        String name,
        List<AlienSpecies> individuals  // Store AlienSpecies objects here
) { }
