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
	* - time      : 2016/10/08 ��Ԫ at 15:07:58 CST
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
 * <p>Title: BnsClothes</p>
 *
 * <p>Description: Domain Object describing a BnsClothes entity</p>
 *
 */
@Entity (name="BnsClothes")
@Table (name="bns_clothes")
@NamedQueries({
	 @NamedQuery(name="BnsClothes.findAll", query="SELECT bnsclothes FROM BnsClothes bnsclothes")
	,@NamedQuery(name="BnsClothes.findByCompany", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.company = :company")
	,@NamedQuery(name="BnsClothes.findByCompanyContaining", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.company like :company")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsClothes.findByName", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.name = :name")
	,@NamedQuery(name="BnsClothes.findByNameContaining", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.name like :name")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsClothes.findByUnit", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.unit = :unit")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsClothes.findByNum", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.num = :num")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsClothes.findByPrice", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.price = :price")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsClothes.findByState", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.state = :state")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsClothes.findByCreatedTime", query="SELECT bnsclothes FROM BnsClothes bnsclothes WHERE bnsclothes.createdTime = :createdTime")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
})
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-annotations@
//MP-MANAGED-ADDED-AREA-ENDING @custom-annotations@
public class BnsClothes implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BnsClothes.findAll";
    public static final String FIND_BY_COMPANY = "BnsClothes.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsClothes.findByCompanyContaining";
    public static final String FIND_BY_NAME = "BnsClothes.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="BnsClothes.findByNameContaining";
    public static final String FIND_BY_UNIT = "BnsClothes.findByUnit";
    public static final String FIND_BY_NUM = "BnsClothes.findByNum";
    public static final String FIND_BY_PRICE = "BnsClothes.findByPrice";
    public static final String FIND_BY_STATE = "BnsClothes.findByState";
    public static final String FIND_BY_CREATEDTIME = "BnsClothes.findByCreatedTime";
	
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
    @Column(name="name"  , length=100 , nullable=true , unique=false)
    private String name; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @unit-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @unit-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-unit@
    @Column(name="unit"   , nullable=true , unique=false)
    private Integer unit; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @num-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @num-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-num@
    @Column(name="num"   , nullable=true , unique=false)
    private Integer num; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @price-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @price-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-price@
    @Column(name="price"   , nullable=true , unique=false)
    private java.math.BigDecimal price; 
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
    public BnsClothes() {
    }

	/**
	* All field constructor 
	*/
    public BnsClothes(
       String id,
       String company,
       String name,
       Integer unit,
       Integer num,
       java.math.BigDecimal price,
       Integer state,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCompany (company);
       setName (name);
       setUnit (unit);
       setNum (num);
       setPrice (price);
       setState (state);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsClothes flat() {
	   return new BnsClothes(
          getId(),
          getCompany(),
          getName(),
          getUnit(),
          getNum(),
          getPrice(),
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-unit@
    public Integer getUnit() {
        return unit;
    }
	
    public void setUnit (Integer unit) {
        this.unit =  unit;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-num@
    public Integer getNum() {
        return num;
    }
	
    public void setNum (Integer num) {
        this.num =  num;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_clothes@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_clothes@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
