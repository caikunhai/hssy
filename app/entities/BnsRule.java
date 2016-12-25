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
	* - time      : 2016/12/24 ��Ԫ at 09:45:02 CST
*/
package entities;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.io.Serializable;
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
 * <p>Title: BnsRule</p>
 *
 * <p>Description: Domain Object describing a BnsRule entity</p>
 *
 */
@Entity (name="BnsRule")
@Table (name="bns_rule")
@NamedQueries({
	 @NamedQuery(name="BnsRule.findAll", query="SELECT bnsrule FROM BnsRule bnsrule")
	,@NamedQuery(name="BnsRule.findByCz", query="SELECT bnsrule FROM BnsRule bnsrule WHERE bnsrule.cz = :cz")

	,@NamedQuery(name="BnsRule.findByZs", query="SELECT bnsrule FROM BnsRule bnsrule WHERE bnsrule.zs = :zs")

	,@NamedQuery(name="BnsRule.findByCreatedTime", query="SELECT bnsrule FROM BnsRule bnsrule WHERE bnsrule.createdTime = :createdTime")

})

public class BnsRule implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final java.math.BigDecimal __DEFAULT_CZ = java.math.BigDecimal.valueOf(0.00);
	public static final java.math.BigDecimal __DEFAULT_ZS = java.math.BigDecimal.valueOf(0.00);

    public static final String FIND_ALL = "BnsRule.findAll";
    public static final String FIND_BY_CZ = "BnsRule.findByCz";
    public static final String FIND_BY_ZS = "BnsRule.findByZs";
    public static final String FIND_BY_CREATEDTIME = "BnsRule.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @cz-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @cz-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-cz@
    @Column(name="cz"   , nullable=true , unique=false)
    private java.math.BigDecimal cz; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @zs-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @zs-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-zs@
    @Column(name="zs"   , nullable=true , unique=false)
    private java.math.BigDecimal zs; 
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
    public BnsRule() {
    }

	/**
	* All field constructor 
	*/
    public BnsRule(
       Long id,
       java.math.BigDecimal cz,
       java.math.BigDecimal zs,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setCz (cz);
       setZs (zs);
       setCreatedTime (createdTime);
       //parents
    }

	public BnsRule flat() {
	   return new BnsRule(
          getId(),
          getCz(),
          getZs(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-cz@
    public java.math.BigDecimal getCz() {
        return cz;
    }
	
    public void setCz (java.math.BigDecimal cz) {
        this.cz =  cz;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-zs@
    public java.math.BigDecimal getZs() {
        return zs;
    }
	
    public void setZs (java.math.BigDecimal zs) {
        this.zs =  zs;
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




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-bns_rule@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (cz==null) cz=__DEFAULT_CZ;
        if (zs==null) zs=__DEFAULT_ZS;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-bns_rule@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (cz==null) cz=__DEFAULT_CZ;
        if (zs==null) zs=__DEFAULT_ZS;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
