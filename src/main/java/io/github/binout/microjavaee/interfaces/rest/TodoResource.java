/*
 * Copyright 2014 Benoit Prioux
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.binout.microjavaee.interfaces.rest;

import io.github.binout.microjavaee.domain.Todo;
import io.github.binout.microjavaee.domain.TodoRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/todos/{todoId}")
public class TodoResource {

    @Inject
    private TodoRepository repository;

    @PathParam("todoId")
    private Long todoId;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Todo todo = repository.get(todoId);
        if (todo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(todo).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Todo todo) throws IOException {
        repository.update(todo);
    }

    @DELETE
    public Response remove() {
        repository.delete(todoId);
        return Response.noContent().build();
    }

}
