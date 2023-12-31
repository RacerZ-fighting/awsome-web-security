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
package org.apache.tiles.freemarker.template;

import java.io.IOException;
import java.util.Map;

import org.apache.tiles.autotag.core.runtime.ModelBody;
import org.apache.tiles.autotag.core.runtime.AutotagRuntime;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * <p>
 * Insert a definition.
 * </p>
 * <p>
 * Insert a definition with the possibility to override and specify parameters
 * (called attributes). A definition can be seen as a (partially or totally)
 * filled template that can override or complete attribute values.
 * &lt;tiles:insertDefinition&gt; allows to define these attributes and pass
 * them to the inserted jsp page, called template. Attributes are defined using
 * nested tag &lt;tiles:putAttribute&gt; or &lt;tiles:putListAttribute&gt;.
 * </p>
 * <p>
 * You must specify name tag attribute, for inserting a definition from
 * definitions factory.
 * </p>
 * <p>
 * Example :
 * </p>
 * 
 * <pre>
 *     &lt;tiles:insertDefinition name=&quot;.my.tiles.defininition flush=&quot;true&quot;&gt;
 *         &lt;tiles:putAttribute name=&quot;title&quot; value=&quot;My first page&quot; /&gt;
 *         &lt;tiles:putAttribute name=&quot;header&quot; value=&quot;/common/header.jsp&quot; /&gt;
 *         &lt;tiles:putAttribute name=&quot;footer&quot; value=&quot;/common/footer.jsp&quot; /&gt;
 *         &lt;tiles:putAttribute name=&quot;menu&quot; value=&quot;/basic/menu.jsp&quot; /&gt;
 *         &lt;tiles:putAttribute name=&quot;body&quot; value=&quot;/basic/helloBody.jsp&quot; /&gt;
 *     &lt;/tiles:insertDefinition&gt;
 * </pre>
 */
public class InsertDefinitionFMModel implements TemplateDirectiveModel {

    /**
     * The template model.
     */
    private org.apache.tiles.template.InsertDefinitionModel model;

    /**
     * Constructor.
     *
     * @param model The template model.
     */
    public InsertDefinitionFMModel(org.apache.tiles.template.InsertDefinitionModel model) {
        this.model = model;
    }

    @Override
    public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
            TemplateDirectiveBody body) throws TemplateException, IOException {
        AutotagRuntime<org.apache.tiles.request.Request> runtime = new org.apache.tiles.request.freemarker.autotag.FreemarkerAutotagRuntime();
        if (runtime instanceof TemplateDirectiveModel) {
            ((TemplateDirectiveModel) runtime).execute(env, params, loopVars, body);
        }
        org.apache.tiles.request.Request request = runtime.createRequest();
        ModelBody modelBody = runtime.createModelBody();
        model.execute(runtime.getParameter("name", java.lang.String.class, null),
                runtime.getParameter("template", java.lang.String.class, null),
                runtime.getParameter("templateType", java.lang.String.class, null),
                runtime.getParameter("templateExpression", java.lang.String.class, null),
                runtime.getParameter("role", java.lang.String.class, null),
                runtime.getParameter("preparer", java.lang.String.class, null),
                runtime.getParameter("flush", java.lang.Boolean.class, false), request, modelBody);
    }
}
