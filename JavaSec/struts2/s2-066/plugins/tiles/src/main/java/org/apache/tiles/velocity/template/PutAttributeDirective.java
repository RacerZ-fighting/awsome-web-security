/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/*
 * This file was automatically generated by Autotag.  Please do not edit it manually.
 */
package org.apache.tiles.velocity.template;

import java.io.IOException;
import java.io.Writer;

import org.apache.tiles.autotag.core.runtime.ModelBody;
import org.apache.tiles.autotag.core.runtime.AutotagRuntime;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

/**
 * <p>
 * Put an attribute in enclosing attribute container tag.
 * </p>
 * <p>
 * Enclosing attribute container tag can be :
 * <ul>
 * <li>&lt;initContainer&gt;</li>
 * <li>&lt;definition&gt;</li>
 * <li>&lt;insertAttribute&gt;</li>
 * <li>&lt;insertDefinition&gt;</li>
 * <li>&lt;putListAttribute&gt;</li>
 * </ul>
 * (or any other tag which implements the PutAttributeTagParent interface.
 * Exception is thrown if no appropriate tag can be found.
 * </p>
 * <p>
 * Put tag can have following atributes :
 * <ul>
 * <li>name : Name of the attribute</li>
 * <li>value : value to put as attribute</li>
 * <li>type : value type. Possible type are : string (value is used as direct
 * string), template (value is used as a page url to insert), definition (value
 * is used as a definition name to insert), object (value is used as it is)</li>
 * <li>role : Role to check when 'insertAttribute' will be called.</li>
 * </ul>
 * </p>
 * <p>
 * Value can also come from tag body. Tag body is taken into account only if
 * value is not set by one of the tag attributes. In this case Attribute type is
 * "string", unless tag body define another type.
 * </p>
 */
public class PutAttributeDirective extends Directive {

    /**
     * The template model.
     */
    private org.apache.tiles.template.PutAttributeModel model = new org.apache.tiles.template.PutAttributeModel();

    @Override
    public String getName() {
        return "tiles_putAttribute";
    }

    @Override
    public int getType() {
        return BLOCK;
    }

    @Override
    public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException {
        AutotagRuntime<org.apache.tiles.request.Request> runtime = new org.apache.tiles.request.velocity.autotag.VelocityAutotagRuntime();
        if (runtime instanceof Directive) {
            ((Directive) runtime).render(context, writer, node);
        }
        org.apache.tiles.request.Request request = runtime.createRequest();
        ModelBody modelBody = runtime.createModelBody();
        model.execute(runtime.getParameter("name", java.lang.String.class, null),
                runtime.getParameter("value", java.lang.Object.class, null),
                runtime.getParameter("expression", java.lang.String.class, null),
                runtime.getParameter("role", java.lang.String.class, null),
                runtime.getParameter("type", java.lang.String.class, null),
                runtime.getParameter("cascade", java.lang.Boolean.class, false), request, modelBody

        );
        return true;
    }
}
