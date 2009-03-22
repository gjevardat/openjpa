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
package org.apache.openjpa.persistence.jdbc.unique;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Data structures for testing unique constraint settings
 * on ORM Annotations.
 * @UniqueConstraint annotation is declared at class-level with @Table, 
 * @SecondaryTable annotations and at field-level with @JoinTable annotation.
 * 
 * The columns included in unique constraint must be non-nullable. This is 
 * recommended that the non-nullability of the column is explictly set by the
 * user, though the implementation forces a column to non-nullable as a column
 * is included in a unique constraint.
 * 
 * @author Pinaki Poddar
 *
 */
@Entity
@Table(name="UNIQUE_A",
	   uniqueConstraints={@UniqueConstraint(columnNames={"a1","a2"}),
		                  @UniqueConstraint(columnNames={"a3","a4"})})
@SecondaryTable(name="UNIQUE_SECONDARY",
		uniqueConstraints=@UniqueConstraint(columnNames={"sa1"}))

public class UniqueA {
	@Id
	private int aid;

	@Column(unique=true, nullable=false)
	private int a1;
	
	@Column(nullable=false)
	private int a2;
	
	@Column(nullable=false)
	private int a3;
	
	@Column(nullable=false)
	private int a4;
	
	
	private int a5;
	private int a6;
	
	@Column(table="UNIQUE_SECONDARY", nullable=false)
	private short sa1;
	@Column(table="UNIQUE_SECONDARY")
	private short sa2;
	
	@ManyToMany
	@JoinTable(name="UNIQUE_JOINTABLE",
			joinColumns={@JoinColumn(name="FK_A", nullable=false, 
					referencedColumnName="aid")},
			inverseJoinColumns={@JoinColumn(name="FK_B", nullable=false, 
					referencedColumnName="bid")},
			uniqueConstraints=@UniqueConstraint(columnNames={"FK_A","FK_B"}))
	private Collection<UniqueB> bs;
}
