/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.result.xslt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapter extends AbstractAdapterElement {

    private static final Logger LOG = LogManager.getLogger(ArrayAdapter.class);

    public ArrayAdapter() {
    }

    public ArrayAdapter(AdapterFactory adapterFactory, AdapterNode parent, String propertyName, Object value) {
        setContext(adapterFactory, parent, propertyName, value);
    }

    @Override
    protected List<Node> buildChildAdapters() {
        List<Node> children = new ArrayList<>();
        Object[] values = (Object[]) getPropertyValue();

        for (Object value : values) {
            Node childAdapter = getAdapterFactory().adaptNode(this, "item", value);
            if (childAdapter != null)
                children.add(childAdapter);

            LOG.debug("{} adding adapter: {}", this, childAdapter);
        }

        return children;
    }
}
