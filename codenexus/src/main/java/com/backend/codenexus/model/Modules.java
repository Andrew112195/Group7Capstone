package com.backend.codenexus.model;
import lombok.Data;
/*implement a linked list datastructures of modules all the way to the end module
* each module has a link to the next module
*  */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Data
public class Modules {
    private long id;
    private long lessonId;
    private String name;
    private String description;
    private Modules nextModule;
    private String subject;
    private Difficulty difficulty;
    private boolean preReq;
    private boolean quizPassed;
    private boolean headModule;
    private boolean lastModule;

}

