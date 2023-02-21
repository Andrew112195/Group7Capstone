package com.backend.codenexus.model;

import java.util.List;
//import java.util.Stack;
import lombok.Data;

/*implement a linked list datastructures of modules all the way to the end module
* each module has a link to the next module
*  */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Data
public class Module {
    private Course courseId;
    private List<Task> tasks;
    private Task[] archive;
    private String name;
    private String description;
    private Difficulty difficulty;
    private boolean preReq;
    private boolean moduleComplete;
}