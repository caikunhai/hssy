/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2016/12/10 ��Ԫ at 18:06:00 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: SysArea</p>
 *
 * <p>Description: Domain Object describing a SysArea entity</p>
 *
 */
@Entity (name="SysArea")
@Table (name="sys_area")
@NamedQueries({
	 @NamedQuery(name="SysArea.findAll", query="SELECT sysarea FROM SysArea sysarea")
	,@NamedQuery(name="SysArea.findByName", query="SELECT sysarea FROM SysArea sysarea WHERE sysarea.name = :name")
	,@NamedQuery(name="SysArea.findByNameContaining", query="SELECT sysarea FROM SysArea sysarea WHERE sysarea.name like :name")

	,@NamedQuery(name="SysArea.findByState", query="SELECT sysarea FROM SysArea sysarea WHERE sysarea.state = :state")

	,@NamedQuery(name="SysArea.findBySort", query="SELECT sysarea FROM SysArea sysarea WHERE sysarea.sort = :sort")

	,@NamedQuery(name="SysArea.findByCreatedTime", query="SELECT sysarea FROM SysArea sysarea WHERE sysarea.createdTime = :createdTime")

})

public class SysArea implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_SORT = Integer.valueOf(0);

    public static final String FIND_ALL = "SysArea.findAll";
    public static final String FIND_BY_NAME = "SysArea.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="SysArea.findByNameContaining";
    public static final String FIND_BY_STATE = "SysArea.findByState";
    public static final String FIND_BY_SORT = "SysArea.findBySort";
    public static final String FIND_BY_CREATEDTIME = "SysArea.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=50 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @sort-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @sort-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-sort@
    @Column(name="sort"   , nullable=true , unique=false)
    private Integer sort; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_time@
    @Column(name="created_time"   , nullable=true , unique=false)
    private Timestamp createdTime; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public SysArea() {
    }

	/**
	* All field constructor 
	*/
    public SysArea(
       Long id,
       String name,
       Integer state,
       Integer sort,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setName (name);
       setState (state);
       setSort (sort);
       setCreatedTime (createdTime);
       //parents
    }

	public SysArea flat() {
	   return new SysArea(
          getId(),
          getName(),
          getState(),
          getSort(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-state@
    public Integer getState() {
        return state;
    }
	
    public void setState (Integer state) {
        this.state =  state;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-sort@
    public Integer getSort() {
        return sort;
    }
	
    public void setSort (Integer sort) {
        this.sort =  sort;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_time@
    public Timestamp getCreatedTime() {
        return createdTime;
    }
	
    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime =  createdTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-sys_area@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (sort==null) sort=__DEFAULT_SORT;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-sys_area@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (sort==null) sort=__DEFAULT_SORT;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
