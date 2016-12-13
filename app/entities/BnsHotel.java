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
	* - time      : 2016/11/07 ��Ԫ at 11:08:34 CST
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
 * <p>Title: BnsHotel</p>
 *
 * <p>Description: Domain Object describing a BnsHotel entity</p>
 *
 */
@Entity (name="BnsHotel")
@Table (name="bns_hotel")
@NamedQueries({
	 @NamedQuery(name="BnsHotel.findAll", query="SELECT bnshotel FROM BnsHotel bnshotel")
	,@NamedQuery(name="BnsHotel.findByCompany", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.company = :company")
	,@NamedQuery(name="BnsHotel.findByCompanyContaining", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.company like :company")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByCity", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.city = :city")
	,@NamedQuery(name="BnsHotel.findByCityContaining", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.city like :city")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByName", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.name = :name")
	,@NamedQuery(name="BnsHotel.findByNameContaining", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.name like :name")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByAddress", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.address = :address")
	,@NamedQuery(name="BnsHotel.findByAddressContaining", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.address like :address")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByLogo", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.logo = :logo")
	,@NamedQuery(name="BnsHotel.findByLogoContaining", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.logo like :logo")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByType", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.type = :type")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByState", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.state = :state")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByStar", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.star = :star")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByDescription", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.description = :description")
	,@NamedQuery(name="BnsHotel.findByDescriptionContaining", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.description like :description")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByPrice", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.price = :price")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByRemark", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.remark = :remark")
	,@NamedQuery(name="BnsHotel.findByRemarkContaining", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.remark like :remark")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsHotel.findByCreatedTime", query="SELECT bnshotel FROM BnsHotel bnshotel WHERE bnshotel.createdTime = :createdTime")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
})
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-annotations@
//MP-MANAGED-ADDED-AREA-ENDING @custom-annotations@
public class BnsHotel implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Integer __DEFAULT_TYPE = Integer.valueOf(0);
	public static final Integer __DEFAULT_STATE = Integer.valueOf(0);
	public static final Integer __DEFAULT_STAR = Integer.valueOf(0);
	public static final java.math.BigDecimal __DEFAULT_PRICE = java.math.BigDecimal.valueOf(0.00);

    public static final String FIND_ALL = "BnsHotel.findAll";
    public static final String FIND_BY_COMPANY = "BnsHotel.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsHotel.findByCompanyContaining";
    public static final String FIND_BY_CITY = "BnsHotel.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="BnsHotel.findByCityContaining";
    public static final String FIND_BY_NAME = "BnsHotel.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="BnsHotel.findByNameContaining";
    public static final String FIND_BY_ADDRESS = "BnsHotel.findByAddress";
    public static final String FIND_BY_ADDRESS_CONTAINING ="BnsHotel.findByAddressContaining";
    public static final String FIND_BY_LOGO = "BnsHotel.findByLogo";
    public static final String FIND_BY_LOGO_CONTAINING ="BnsHotel.findByLogoContaining";
    public static final String FIND_BY_TYPE = "BnsHotel.findByType";
    public static final String FIND_BY_STATE = "BnsHotel.findByState";
    public static final String FIND_BY_STAR = "BnsHotel.findByStar";
    public static final String FIND_BY_DESCRIPTION = "BnsHotel.findByDescription";
    public static final String FIND_BY_DESCRIPTION_CONTAINING ="BnsHotel.findByDescriptionContaining";
    public static final String FIND_BY_PRICE = "BnsHotel.findByPrice";
    public static final String FIND_BY_REMARK = "BnsHotel.findByRemark";
    public static final String FIND_BY_REMARK_CONTAINING ="BnsHotel.findByRemarkContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsHotel.findByCreatedTime";
	
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
    @Column(name="logo"  , length=100 , nullable=true , unique=false)
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

//MP-MANAGED-ADDED-AREA-BEGINNING @star-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @star-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-star@
    @Column(name="star"   , nullable=true , unique=false)
    private Integer star; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @description-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @description-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-description@
    @Column(name="description"  , length=255 , nullable=true , unique=false)
    private String description; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @price-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @price-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-price@
    @Column(name="price"   , nullable=true , unique=false)
    private java.math.BigDecimal price; 
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
    public BnsHotel() {
    }

	/**
	* All field constructor 
	*/
    public BnsHotel(
       String id,
       String company,
       String city,
       String name,
       String address,
       String logo,
       Integer type,
       Integer state,
       Integer star,
       String description,
       java.math.BigDecimal price,
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
       setStar (star);
       setDescription (description);
       setPrice (price);
       setRemark (remark);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsHotel flat() {
	   return new BnsHotel(
          getId(),
          getCompany(),
          getCity(),
          getName(),
          getAddress(),
          getLogo(),
          getType(),
          getState(),
          getStar(),
          getDescription(),
          getPrice(),
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-star@
    public Integer getStar() {
        return star;
    }
	
    public void setStar (Integer star) {
        this.star =  star;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-price@
    public java.math.BigDecimal getPrice() {
        return price;
    }
	
    public void setPrice (java.math.BigDecimal price) {
        this.price =  price;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_hotel@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (type==null) type=__DEFAULT_TYPE;
        if (state==null) state=__DEFAULT_STATE;
        if (star==null) star=__DEFAULT_STAR;
        if (price==null) price=__DEFAULT_PRICE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_hotel@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (type==null) type=__DEFAULT_TYPE;
        if (state==null) state=__DEFAULT_STATE;
        if (star==null) star=__DEFAULT_STAR;
        if (price==null) price=__DEFAULT_PRICE;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
