package cdac.HibernateMMMapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="testmcq")
public class MultiQuestion {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
  private  int questionId;
  private   String questionName;
  @ManyToMany(targetEntity = MultiAnswers.class,cascade = CascadeType.ALL)
  @JoinTable(name="testmcq_join",
  //A join table is typically used in the mapping of many-to-many and unidirectional one-to-many associations. 
  //It may also be used tomap bidirectional many-to-one/one-to-many associations,unidirectional many-to-one relationships, and 
  //one-to-oneassociations (both bidirectional and unidirectional). 
  joinColumns = {@JoinColumn(name="mcqqid")},
  //The foreign key columns of the join table which reference the primary table of the entity that doesnot own the association. 
  //(I.e. the inverse side of the association). 
  inverseJoinColumns = {@JoinColumn(name="mcqansid")})
  
  private  List<MultiAnswers> answers;
  
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public List<MultiAnswers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<MultiAnswers> answers) {
		this.answers = answers;
	}
  
  
}
