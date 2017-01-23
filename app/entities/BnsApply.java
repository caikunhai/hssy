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
	* - time      : 2017/01/21 ��Ԫ at 17:02:50 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsApply</p>
 *
 * <p>Description: Domain Object describing a BnsApply entity</p>
 *
 */
@Entity (name="BnsApply")
@Table (name="bns_apply")
@NamedQueries({
	 @NamedQuery(name="BnsApply.findAll", query="SELECT bnsapply FROM BnsApply bnsapply")
	,@NamedQuery(name="BnsApply.findByCompany", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.company = :company")
	,@NamedQuery(name="BnsApply.findByCompanyContaining", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.company like :company")

	,@NamedQuery(name="BnsApply.findByName", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.name = :name")
	,@NamedQuery(name="BnsApply.findByNameContaining", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.name like :name")

	,@NamedQuery(name="BnsApply.findByAddress", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.address = :address")
	,@NamedQuery(name="BnsApply.findByAddressContaining", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.address like :address")

	,@NamedQuery(name="BnsApply.findByFrName", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.frName = :frName")
	,@NamedQuery(name="BnsApply.findByFrNameContaining", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.frName like :frName")

	,@NamedQuery(name="BnsApply.findByFrMobile", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.frMobile = :frMobile")
	,@NamedQuery(name="BnsApply.findByFrMobileContaining", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.frMobile like :frMobile")

	,@NamedQuery(name="BnsApply.findByGos", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.gos = :gos")
	,@NamedQuery(name="BnsApply.findByGosContaining", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.gos like :gos")

	,@NamedQuery(name="BnsApply.findByState", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.state = :state")

	,@NamedQuery(name="BnsApply.findByCreatedTime", query="SELECT bnsapply FROM BnsApply bnsapply WHERE bnsapply.createdTime = :createdTime")

})

public class BnsApply implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);

    public static final String FIND_ALL = "BnsApply.findAll";
    public static final String FIND_BY_COMPANY = "BnsApply.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsApply.findByCompanyContaining";
    public static final String FIND_BY_NAME = "BnsApply.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="BnsApply.findByNameContaining";
    public static final String FIND_BY_ADDRESS = "BnsApply.findByAddress";
    public static final String FIND_BY_ADDRESS_CONTAINING ="BnsApply.findByAddressContaining";
    public static final String FIND_BY_FRNAME = "BnsApply.findByFrName";
    public static final String FIND_BY_FRNAME_CONTAINING ="BnsApply.findByFrNameContaining";
    public static final String FIND_BY_FRMOBILE = "BnsApply.findByFrMobile";
    public static final String FIND_BY_FRMOBILE_CONTAINING ="BnsApply.findByFrMobileContaining";
    public static final String FIND_BY_GOS = "BnsApply.findByGos";
    public static final String FIND_BY_GOS_CONTAINING ="BnsApply.findByGosContaining";
    public static final String FIND_BY_STATE = "BnsApply.findByState";
    public static final String FIND_BY_CREATEDTIME = "BnsApply.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @company-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @company-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-company@
    @Column(name="company"  , length=64 , nullable=true , unique=false)
    private String company; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=60 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @address-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @address-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-address@
    @Column(name="address"  , length=100 , nullable=true , unique=false)
    private String address; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @fr_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @fr_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-fr_name@
    @Column(name="fr_name"  , length=30 , nullable=true , unique=false)
    private String frName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @fr_mobile-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @fr_mobile-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-fr_mobile@
    @Column(name="fr_mobile"  , length=20 , nullable=true , unique=false)
    private String frMobile; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @gos-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @gos-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-gos@
    @Column(name="gos"  , length=255 , nullable=true , unique=false)
    private String gos; 
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
    public BnsApply() {
    }

	/**
	* All field constructor 
	*/
    public BnsApply(
       String id,
       String company,
       String name,
       String address,
       String frName,
       String frMobile,
       String gos,
       Integer state,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCompany (company);
       setName (name);
       setAddress (address);
       setFrName (frName);
       setFrMobile (frMobile);
       setGos (gos);
       setState (state);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsApply flat() {
	   return new BnsApply(
          getId(),
          getCompany(),
          getName(),
          getAddress(),
          getFrName(),
          getFrMobile(),
          getGos(),
          getState(),
          getCreatedTime()
	   );
	}

    public String getId() {
        return id;
    }
	
    public void setId (String id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-company@
    public String getCompany() {
        return company;
    }
	
    public void setCompany (String company) {
        this.company =  company;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-address@
    public String getAddress() {
        return address;
    }
	
    public void setAddress (String address) {
        this.address =  address;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-fr_name@
    public String getFrName() {
        return frName;
    }
	
    public void setFrName (String frName) {
        this.frName =  frName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-fr_mobile@
    public String getFrMobile() {
        return frMobile;
    }
	
    public void setFrMobile (String frMobile) {
        this.frMobile =  frMobile;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-gos@
    public String getGos() {
        return gos;
    }
	
    public void setGos (String gos) {
        this.gos =  gos;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_apply@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_apply@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (state==null) state=__DEFAULT_STATE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
