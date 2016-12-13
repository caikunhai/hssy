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
 * <p>Title: SysMenuRole</p>
 *
 * <p>Description: Domain Object describing a SysMenuRole entity</p>
 *
 */
@Entity (name="SysMenuRole")
@Table (name="sys_menu_role")
@NamedQueries({
	 @NamedQuery(name="SysMenuRole.findAll", query="SELECT sysmenurole FROM SysMenuRole sysmenurole")
	,@NamedQuery(name="SysMenuRole.findByMenu", query="SELECT sysmenurole FROM SysMenuRole sysmenurole WHERE sysmenurole.menu = :menu")

	,@NamedQuery(name="SysMenuRole.findByRole", query="SELECT sysmenurole FROM SysMenuRole sysmenurole WHERE sysmenurole.role = :role")

	,@NamedQuery(name="SysMenuRole.findByCreatedTime", query="SELECT sysmenurole FROM SysMenuRole sysmenurole WHERE sysmenurole.createdTime = :createdTime")

})

public class SysMenuRole implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "SysMenuRole.findAll";
    public static final String FIND_BY_MENU = "SysMenuRole.findByMenu";
    public static final String FIND_BY_ROLE = "SysMenuRole.findByRole";
    public static final String FIND_BY_CREATEDTIME = "SysMenuRole.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @menu-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @menu-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-menu@
    @Column(name="menu"   , nullable=true , unique=false)
    private Long menu; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @role-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @role-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-role@
    @Column(name="role"   , nullable=true , unique=false)
    private Integer role; 
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
    public SysMenuRole() {
    }

	/**
	* All field constructor 
	*/
    public SysMenuRole(
       Long id,
       Long menu,
       Integer role,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setMenu (menu);
       setRole (role);
       setCreatedTime (createdTime);
       //parents
    }

	public SysMenuRole flat() {
	   return new SysMenuRole(
          getId(),
          getMenu(),
          getRole(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-menu@
    public Long getMenu() {
        return menu;
    }
	
    public void setMenu (Long menu) {
        this.menu =  menu;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-role@
    public Integer getRole() {
        return role;
    }
	
    public void setRole (Integer role) {
        this.role =  role;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-sys_menu_role@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-sys_menu_role@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
