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
package org.apache.openjpa.junit5.internal;

import org.apache.openjpa.junit5.OpenJPASupport;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.util.logging.Logger;

public class OpenJPAExtension implements BeforeAllCallback {
    private static final Logger LOGGER = Logger.getLogger(OpenJPAExtension.class.getName());

    @Override
    public void beforeAll(final ExtensionContext context) {
        AnnotationUtils.findAnnotation(context.getElement(), OpenJPASupport.class)
                .ifPresent(s -> new OpenJPADirectoriesEnhancer(s.auto(), s.entities(), s.logFactory()).run());
    }
}
