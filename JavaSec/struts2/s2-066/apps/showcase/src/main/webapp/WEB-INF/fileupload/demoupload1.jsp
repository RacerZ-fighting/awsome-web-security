<!--
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
-->
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Struts2 Showcase - uploadFile sample</title>
</head>

<body>
<div class="page-header">
    <h1>uploadFile sample</h1>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <s:actionerror cssClass="alert alert-error"/>
            <s:fielderror cssClass="alert alert-error"/>
            <s:form action="upFile" method="POST" enctype="multipart/form-data">
                <s:file name="upload" label="File"/>
                <s:textfield name="caption" label="Caption"/>
                <s:submit cssClass="btn btn-primary"/>
            </s:form>
        </div>
    </div>
</div>
</body>
</html>

