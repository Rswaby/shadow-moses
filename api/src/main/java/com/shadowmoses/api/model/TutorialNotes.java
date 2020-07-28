package com.shadowmoses.api.model;

public class TutorialNotes {
    //query
    //    public Iterable<Tutorial> findAllTutorials(){
    //        return tutorialRepository.findAll();
    //
//Mutation
//    public Tutorial createTutorial(String title, String description, String authorId) {
//        Tutorial book = Tutorial.builder()
//                .author_id(authorId)
//                .title(title)
//                .description(description)
//                .build();
//        tutorialRepository.save(book);
//        return book;
//    }
//
//
//
//    public boolean deleteTutorial(String id) {
//        tutorialRepository.deleteById(id);
//        return true;
//    }
//
//    public Tutorial updateTutorial(String id, String title, String description) throws Exception {
//        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);
//
//        if (optTutorial.isPresent()) {
//            Tutorial tutorial = optTutorial.get();
//
//            if (title != null)
//                tutorial.setTitle(title);
//            if (description != null)
//                tutorial.setDescription(description);
//
//            tutorialRepository.save(tutorial);
//            return tutorial;
//        }
//
//        throw new Exception("Not found Tutorial to update!");
//    }
}
