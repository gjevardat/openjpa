/*
 * TestSavepointEmbeddedPreFlush.java
 *
 * Created on October 16, 2006, 10:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
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
package org.apache.openjpa.persistence.kernel;





public class TestSavepointEmbeddedPreFlush extends TestSavepointEmbedded {

    /**
     * Creates a new instance of TestSavepointEmbeddedPreFlush
     */
    public TestSavepointEmbeddedPreFlush(String name) {
        super(name);
    }

    @Override
    protected String getSavepointPlugin() {
        return "in-mem(PreFlush=true)";
    }

    @Override
    protected boolean expectNewEmbeddedFailure() {
        return false;
    }
}
