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
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2016/12/20 ��Ԫ at 00:23:44 CST
*/
package entities;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(BnsOrderChild.class)
public class BnsOrderChild_ {

    public static volatile SingularAttribute<BnsOrderChild, String> id;

    public static volatile SingularAttribute<BnsOrderChild, String> customer;
    public static volatile SingularAttribute<BnsOrderChild, String> idcard;
    public static volatile SingularAttribute<BnsOrderChild, String> mobile;
    public static volatile SingularAttribute<BnsOrderChild, Integer> people;
    public static volatile SingularAttribute<BnsOrderChild, String> cloth;
    public static volatile SingularAttribute<BnsOrderChild, String> site;
    public static volatile SingularAttribute<BnsOrderChild, String> hotel;
    public static volatile SingularAttribute<BnsOrderChild, Integer> pickup;
    public static volatile SingularAttribute<BnsOrderChild, String> remark;
    public static volatile SingularAttribute<BnsOrderChild, String> imgs;
    public static volatile SingularAttribute<BnsOrderChild, Timestamp> createdTime;




}
