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
	* - time      : 2016/12/13 ��Ԫ at 23:26:35 CST
*/
package entities;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: BnsSite</p>
 *
 * <p>Description: Domain Object describing a BnsSite entity</p>
 *
 */
@Entity (name="BnsSite")
@Table (name="bns_site")
@NamedQueries({
	 @NamedQuery(name="BnsSite.findAll", query="SELECT bnssite FROM BnsSite bnssite")
	,@NamedQuery(name="BnsSite.findByCompany", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.company = :company")
	,@NamedQuery(name="BnsSite.findByCompanyContaining", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.company like :company")

	,@NamedQuery(name="BnsSite.findByCity", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.city = :city")
	,@NamedQuery(name="BnsSite.findByCityContaining", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.city like :city")

	,@NamedQuery(name="BnsSite.findByName", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.name = :name")
	,@NamedQuery(name="BnsSite.findByNameContaining", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.name like :name")

	,@NamedQuery(name="BnsSite.findByAddress", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.address = :address")
	,@NamedQuery(name="BnsSite.findByAddressContaining", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.address like :address")

	,@NamedQuery(name="BnsSite.findByLogo", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.logo = :logo")
	,@NamedQuery(name="BnsSite.findByLogoContaining", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.logo like :logo")

	,@NamedQuery(name="BnsSite.findByType", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.type = :type")

	,@NamedQuery(name="BnsSite.findByState", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.state = :state")

	,@NamedQuery(name="BnsSite.findByDescription", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.description = :description")
	,@NamedQuery(name="BnsSite.findByDescriptionContaining", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.description like :description")

	,@NamedQuery(name="BnsSite.findByMoney", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.money = :money")

	,@NamedQuery(name="BnsSite.findByRemark", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.remark = :remark")
	,@NamedQuery(name="BnsSite.findByRemarkContaining", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.remark like :remark")

	,@NamedQuery(name="BnsSite.findByCreatedTime", query="SELECT bnssite FROM BnsSite bnssite WHERE bnssite.createdTime = :createdTime")

})

public class BnsSite implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_TYPE = Integer.valueOf(0);
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);
	public static final java.math.BigDecimal __DEFAULT_MONEY = java.math.BigDecimal.valueOf(0.00);

    public static final String FIND_ALL = "BnsSite.findAll";
    public static final String FIND_BY_COMPANY = "BnsSite.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsSite.findByCompanyContaining";
    public static final String FIND_BY_CITY = "BnsSite.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="BnsSite.findByCityContaining";
    public static final String FIND_BY_NAME = "BnsSite.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="BnsSite.findByNameContaining";
    public static final String FIND_BY_ADDRESS = "BnsSite.findByAddress";
    public static final String FIND_BY_ADDRESS_CONTAINING ="BnsSite.findByAddressContaining";
    public static final String FIND_BY_LOGO = "BnsSite.findByLogo";
    public static final String FIND_BY_LOGO_CONTAINING ="BnsSite.findByLogoContaining";
    public static final String FIND_BY_TYPE = "BnsSite.findByType";
    public static final String FIND_BY_STATE = "BnsSite.findByState";
    public static final String FIND_BY_DESCRIPTION = "BnsSite.findByDescription";
    public static final String FIND_BY_DESCRIPTION_CONTAINING ="BnsSite.findByDescriptionContaining";
    public static final String FIND_BY_MONEY = "BnsSite.findByMoney";
    public static final String FIND_BY_REMARK = "BnsSite.findByRemark";
    public static final String FIND_BY_REMARK_CONTAINING ="BnsSite.findByRemarkContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsSite.findByCreatedTime";
	
    @Id @Column(name="id" ,length=64) 
    private String id;

//MP-MANAGED-ADDED-AREA-BEGINNING @company-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @company-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-company@
    @Column(name="company"  , length=64 , nullable=true , unique=false)
    private String company; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @city-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @city-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-city@
    @Column(name="city"  , length=64 , nullable=true , unique=false)
    private String city; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-name@
    @Column(name="name"  , length=50 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @address-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @address-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-address@
    @Column(name="address"  , length=150 , nullable=true , unique=false)
    private String address; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @logo-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @logo-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-logo@
    @Column(name="logo"   , nullable=true , unique=false)
    private String logo; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-type@
    @Column(name="type"   , nullable=true , unique=false)
    private Integer type; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @state-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @state-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-state@
    @Column(name="state"   , nullable=true , unique=false)
    private Integer state; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @description-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @description-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-description@
    @Column(name="description"  , length=255 , nullable=true , unique=false)
    private String description; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-money@
    @Column(name="money"   , nullable=true , unique=false)
    private java.math.BigDecimal money; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @remark-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @remark-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-remark@
    @Column(name="remark"  , length=100 , nullable=true , unique=false)
    private String remark; 
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
    public BnsSite() {
    }

	/**
	* All field constructor 
	*/
    public BnsSite(
       String id,
       String company,
       String city,
       String name,
       String address,
       String logo,
       Integer type,
       Integer state,
       String description,
       java.math.BigDecimal money,
       String remark,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCompany (company);
       setCity (city);
       setName (name);
       setAddress (address);
       setLogo (logo);
       setType (type);
       setState (state);
       setDescription (description);
       setMoney (money);
       setRemark (remark);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsSite flat() {
	   return new BnsSite(
          getId(),
          getCompany(),
          getCity(),
          getName(),
          getAddress(),
          getLogo(),
          getType(),
          getState(),
          getDescription(),
          getMoney(),
          getRemark(),
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-city@
    public String getCity() {
        return city;
    }
	
    public void setCity (String city) {
        this.city =  city;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-logo@
    public String getLogo() {
        return logo;
    }
	
    public void setLogo (String logo) {
        this.logo =  logo;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-type@
    public Integer getType() {
        return type;
    }
	
    public void setType (Integer type) {
        this.type =  type;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-description@
    public String getDescription() {
        return description;
    }
	
    public void setDescription (String description) {
        this.description =  description;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-money@
    public java.math.BigDecimal getMoney() {
        return money;
    }
	
    public void setMoney (java.math.BigDecimal money) {
        this.money =  money;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-remark@
    public String getRemark() {
        return remark;
    }
	
    public void setRemark (String remark) {
        this.remark =  remark;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_site@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (type==null) type=__DEFAULT_TYPE;
        if (state==null) state=__DEFAULT_STATE;
        if (money==null) money=__DEFAULT_MONEY;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_site@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (type==null) type=__DEFAULT_TYPE;
        if (state==null) state=__DEFAULT_STATE;
        if (money==null) money=__DEFAULT_MONEY;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
