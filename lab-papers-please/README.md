# Intro laboratory

## Objective.

This lab is inspired by the game: Papers, Please.

The primary task in the game is for the player to decide whether to grant or deny individuals entry into the city, based on their papers data.

The lab builds on the premise, but has some modified rules and background story, for a more light-hearted experience.

## Story background.

In a distant future, a software engineering intern has force pushed some untested code before the deadline to the multiverse codebase.

This mishap by the intern has caused the merging and colliding of our Moldavian Universe with a few fictional ones.

Even though the locals remained, individuals from the foreign universes have suddenly appeared. The foreigners even though curious about the Moldovian culture, want to get back to their own universes.

The issue is, they have no idea what the mutliverse is, and where do they belong.

## The solution

The Senior students of the Technical University of Moldova, being well-versed in pop-culture, recognize that the visitors can be sorted into four finctional universes.

A classification system is therefore agreed upon and documented in `classification.md`, the only thing remaining is to streamline the process of sending these travelers back to their correct universes.

Using the classification system, and an input file of all the registered individuals, the only thing left is to write an Object-Oriented system that does the automated classification.

### Inspirations for universes:

- Book - The Hitchhicker's guide to the galaxy

- Marvel Universe

- Star Wars Universe

- Lord of the Rings Universe

## Technical

`input.json` contains the list of the individuals. Some entries have full info, some partial. Using the Classification in `classification.md` write to 4 output files the grouped result per universe.

`output` folder is how your end solution should write the files.

Some primitive solutions for a few languages have been provided by the government and are stored in `<language>-classification`. They are slow and manual, but decent place to experiment and start the final solution. Feel free to copy and build from those.

# Project: Alien Classification System

## Overview
This project is an object-oriented system designed to classify alien species from a JSON dataset into various fictional universes. The goal is to build familiarity with core OOP concepts, file I/O, JSON handling, and implementing classification logic.

## Daily Progress and Updates

### Day 1: Git and Base Class Setup
- **Tasks**: Initialize the project in Git, create a base `AlienSpecies` class to represent individual aliens, and configure GitHub for version control.
- **Objective**: Establish a starting structure with Git workflow, allowing consistent version tracking.

### Day 2: Reading from `input.json`
- **Tasks**: Load and parse `input.json` using Jackson’s `ObjectMapper` to read JSON data into the program.
- **Methods Used**: `ObjectMapper.readTree()` and `JsonNode` for JSON parsing.
- **Objective**: Gain experience with file handling and JSON parsing using Jackson, with an emphasis on converting raw JSON data into manageable objects.

### Day 3: Mapping JSON to Classes
- **Tasks**: Map JSON data to instances of `AlienSpecies` and store them in a list, experimenting with printing and filtering alien attributes.
- **Changes**: Created lists to store `AlienSpecies` objects and practiced debugging and filtering (e.g., print only IDs, filter even/odd IDs).
- **Objective**: Improve comfort with JSON-to-class mapping and gain insights into handling collections of objects.

### Day 4: Classification System
- **Tasks**: Design a classification system to assign aliens to different universes based on specific attributes (e.g., `planet`).
- **Design Choices**: Classification was based on known planets, as specified in the JSON data. Aliens with planets like “Kashyyyk” were assigned to `starWars`, while others were categorized under `hitchHikers`, `marvel`, or `rings`.
- **Methods Used**: Switch statements to determine the universe assignment and map functions to create lists of aliens for each universe.
- **Objective**: Develop the core classification logic and ensure flexibility for future modifications, allowing for planet-based or other attribute-based classification.

### Day 5: Output Files and Refactoring
- **Tasks**: Review and refactor code, create a `View` class to handle JSON output, and output classified universes and planet-based alien lists as JSON files.
- **Specific Techniques**: The `View` class uses Jackson to serialize `Universe` and `AlienSpecies` objects back into JSON strings, allowing for organized output files by universe and planet.
- **Objective**: Finalize the output, improve code organization by separating JSON writing into a dedicated class, and create a cleaner, more maintainable codebase.

## Key Components

1. **AlienSpecies Class**: Represents each alien with attributes like `id`, `isHumanoid`, `planet`, `age`, and `traits`.
2. **Universe Class**: Stores a list of aliens belonging to a particular universe, allowing classification to be modular.
3. **View Class**: Handles the output of classified data, encoding objects into JSON files by universe and planet.
4. **Main Class**: Coordinates reading data, classifying aliens, and utilizing the `View` class for output.

## Why This Classification?
The classification by `planet` aligns with common themes in fictional universes, providing a natural way to separate alien species into groups that reflect their universe of origin. This method also supports potential expansions to additional universes and planets.

## Running the Program
1. Ensure `input.json` is in the specified path.
2. Run `Main`, which will classify aliens and output JSON files into the `/output` folder by universe and planet.

## Git and Submission
Each stage was committed with detailed messages. A final Pull Request consolidates the work, adhering to submission guidelines.
