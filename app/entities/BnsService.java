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
	* - time      : 2017/01/05 ��Ԫ at 23:49:41 CST
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
 * <p>Title: BnsService</p>
 *
 * <p>Description: Domain Object describing a BnsService entity</p>
 *
 */
@Entity (name="BnsService")
@Table (name="bns_service")
@NamedQueries({
	 @NamedQuery(name="BnsService.findAll", query="SELECT bnsservice FROM BnsService bnsservice")
	,@NamedQuery(name="BnsService.findByCompany", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.company = :company")
	,@NamedQuery(name="BnsService.findByCompanyContaining", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.company like :company")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByName", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.name = :name")
	,@NamedQuery(name="BnsService.findByNameContaining", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.name like :name")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByMoney", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.money = :money")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByUnit", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.unit = :unit")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByNum", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.num = :num")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByAdditional", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.additional = :additional")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByPrice", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.price = :price")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByState", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.state = :state")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByRemark", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.remark = :remark")
	,@NamedQuery(name="BnsService.findByRemarkContaining", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.remark like :remark")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
	,@NamedQuery(name="BnsService.findByCreatedTime", query="SELECT bnsservice FROM BnsService bnsservice WHERE bnsservice.createdTime = :createdTime")
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-queries@
//MP-MANAGED-ADDED-AREA-ENDING @custom-queries@
})
//MP-MANAGED-ADDED-AREA-BEGINNING @custom-annotations@
//MP-MANAGED-ADDED-AREA-ENDING @custom-annotations@
public class BnsService implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "BnsService.findAll";
    public static final String FIND_BY_COMPANY = "BnsService.findByCompany";
    public static final String FIND_BY_COMPANY_CONTAINING ="BnsService.findByCompanyContaining";
    public static final String FIND_BY_NAME = "BnsService.findByName";
    public static final String FIND_BY_NAME_CONTAINING ="BnsService.findByNameContaining";
    public static final String FIND_BY_MONEY = "BnsService.findByMoney";
    public static final String FIND_BY_UNIT = "BnsService.findByUnit";
    public static final String FIND_BY_NUM = "BnsService.findByNum";
    public static final String FIND_BY_ADDITIONAL = "BnsService.findByAdditional";
    public static final String FIND_BY_PRICE = "BnsService.findByPrice";
    public static final String FIND_BY_STATE = "BnsService.findByState";
    public static final String FIND_BY_REMARK = "BnsService.findByRemark";
    public static final String FIND_BY_REMARK_CONTAINING ="BnsService.findByRemarkContaining";
    public static final String FIND_BY_CREATEDTIME = "BnsService.findByCreatedTime";
	
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

//MP-MANAGED-ADDED-AREA-BEGINNING @money-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @money-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-money@
    @Column(name="money"   , nullable=true , unique=false)
    private java.math.BigDecimal money; 
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

//MP-MANAGED-ADDED-AREA-BEGINNING @additional-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @additional-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-additional@
    @Column(name="additional"   , nullable=true , unique=false)
    private Integer additional; 
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

//MP-MANAGED-ADDED-AREA-BEGINNING @remark-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @remark-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-remark@
    @Column(name="remark"  , length=255 , nullable=true , unique=false)
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
    public BnsService() {
    }

	/**
	* All field constructor 
	*/
    public BnsService(
       String id,
       String company,
       String name,
       java.math.BigDecimal money,
       Integer unit,
       Integer num,
       Integer additional,
       java.math.BigDecimal price,
       Integer state,
       String remark,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCompany (company);
       setName (name);
       setMoney (money);
       setUnit (unit);
       setNum (num);
       setAdditional (additional);
       setPrice (price);
       setState (state);
       setRemark (remark);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsService flat() {
	   return new BnsService(
          getId(),
          getCompany(),
          getName(),
          getMoney(),
          getUnit(),
          getNum(),
          getAdditional(),
          getPrice(),
          getState(),
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-name@
    public String getName() {
        return name;
    }
	
    public void setName (String name) {
        this.name =  name;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-additional@
    public Integer getAdditional() {
        return additional;
    }
	
    public void setAdditional (Integer additional) {
        this.additional =  additional;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_service@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_service@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
