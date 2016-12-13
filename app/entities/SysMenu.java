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
	* - time      : 2016/11/15 ��Ԫ at 21:46:25 CST
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
 * <p>Title: SysMenu</p>
 *
 * <p>Description: Domain Object describing a SysMenu entity</p>
 *
 */
@Entity (name="SysMenu")
@Table (name="sys_menu")
@NamedQueries({
	 @NamedQuery(name="SysMenu.findAll", query="SELECT sysmenu FROM SysMenu sysmenu")
	,@NamedQuery(name="SysMenu.findByParent", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.parent = :parent")

	,@NamedQuery(name="SysMenu.findByName", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.name = :name")
	,@NamedQuery(name="SysMenu.findByNameContaining", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.name like :name")

	,@NamedQuery(name="SysMenu.findByIcon", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.icon = :icon")
	,@NamedQuery(name="SysMenu.findByIconContaining", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.icon like :icon")

	,@NamedQuery(name="SysMenu.findByUrl", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.url = :url")
	,@NamedQuery(name="SysMenu.findByUrlContaining", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.url like :url")

	,@NamedQuery(name="SysMenu.findByState", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.state = :state")

	,@NamedQuery(name="SysMenu.findByCreatedTime", query="SELECT sysmenu FROM SysMenu sysmenu WHERE sysmenu.createdTime = :createdTime")

})

public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Long __DEFAULT_PARENT = Long.valueOf(0);
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);

    public static final String FIND_ALL = "SysMenu.findAll";
    public static final String FIND_BY_PARENT = "SysMenu.findByParent";
    public static final String FIND_BY_NAME = "SysMenu.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="SysMenu.findByNameContaining";
    public static final String FIND_BY_ICON = "SysMenu.findByIcon";
    public static final String FIND_BY_ICON_CONTAINING ="SysMenu.findByIconContaining";
    public static final String FIND_BY_URL = "SysMenu.findByUrl";
    public static final String FIND_BY_URL_CONTAINING ="SysMenu.findByUrlContaining";
    public static final String FIND_BY_STATE = "SysMenu.findByState";
    public static final String FIND_BY_CREATEDTIME = "SysMenu.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @parent-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @parent-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-parent@
    @Column(name="parent"   , nullable=true , unique=false)
    private Long parent; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=30 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @icon-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @icon-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-icon@
    @Column(name="icon"  , length=20 , nullable=true , unique=false)
    private String icon; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @url-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @url-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-url@
    @Column(name="url"  , length=100 , nullable=true , unique=false)
    private String url; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
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
    public SysMenu() {
    }

	/**
	* All field constructor 
	*/
    public SysMenu(
       Long id,
       Long parent,
       String name,
       String icon,
       String url,
       Integer state,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setParent (parent);
       setName (name);
       setIcon (icon);
       setUrl (url);
       setState (state);
       setCreatedTime (createdTime);
       //parents
    }

	public SysMenu flat() {
	   return new SysMenu(
          getId(),
          getParent(),
          getName(),
          getIcon(),
          getUrl(),
          getState(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-parent@
    public Long getParent() {
        return parent;
    }
	
    public void setParent (Long parent) {
        this.parent =  parent;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-icon@
    public String getIcon() {
        return icon;
    }
	
    public void setIcon (String icon) {
        this.icon =  icon;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-url@
    public String getUrl() {
        return url;
    }
	
    public void setUrl (String url) {
        this.url =  url;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_time@
    public Timestamp getCreatedTime() {
        return createdTime;
    }
	
    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime =  createdTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-sys_menu@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (parent==null) parent=__DEFAULT_PARENT;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-sys_menu@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (parent==null) parent=__DEFAULT_PARENT;
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
