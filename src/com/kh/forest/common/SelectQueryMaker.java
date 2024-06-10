package com.kh.forest.common;

import java.util.List;

public class SelectQueryMaker {
	private final StringBuilder query;
	
	public static class Builder {
		private final StringBuilder query;
		
		public Builder() {
			this.query = new StringBuilder();
		}
		
		public Builder(StringBuilder query) {
			this.query = query;
		}
		
		public Builder(String query) {
			this.query = new StringBuilder(query);
		}
		
		public Builder select() {
			query.append("SELECT ");
			
			return this;
		}
		
		public Builder columns(List<String> columns) {
			if(columns != null && columns.size() != 0) {
				for(int i = 0; i < columns.size(); i++) {
					if(i == columns.size() - 1) {
						query.append(columns.get(i));
					} else {
						query.append(columns.get(i)).append(", ");
					}
				}
			} 
			
			return this;
		}
		
		public Builder column(String column) {
			query.append(column);
			
			return this;
		}
		
		public Builder comma() {
			query.append(", ");
			
			return this;
		}
		
		public Builder from() {
			query.append("FROM ");
			
			return this; 
		}
		
		public Builder tableName(String tableName) {
			query.append(tableName + " ");
			
			return this;
		}
		
		public Builder as(String alias) {
			query.append(" " + alias + " ");
			
			return this;
		}
		
		public Builder join() {
			query.append("JOIN ");
			
			return this;
		}
		
		public Builder on() {
			query.append("ON").append(" ");
			
			return this;
		}
		
		public Builder using() {
			query.append("USING").append(" " );
			
			return this;
		}
		
		public Builder usingColumn(String colName) {
			query.append("(").append(colName).append(")").append(" ");
			
			return this;
		}
		
		public Builder equalCondition(String first, String last) {
			query.append("(").append(first).append(" = ").append(last).append(")").append(" ");
			
			return this;
		}
		
		public Builder nonEqualCondition(String first, String last, String op) {
			query.append("(")
				.append(first)
				.append(" ")
				.append(op)
				.append(" ")
				.append(last)
				.append(")")
				.append(" ");
			
			return this;
		}
		
		public Builder where() {
			query.append("WHERE").append(" ");
			
			return this;
		}
		
		public Builder columnName(String colName) {
			query.append(colName).append(" ");
			
			return this;
		}
		
		public Builder operator(String op) {
			query.append(op).append(" ");
			
			return this;
		}
		
		public Builder equal() {
			query.append("=").append(" ");
			
			return this;
		}
		
		public Builder nonEqual() {
			query.append("<>").append(" ");
			
			return this;
		}
		
		public Builder isNull() {
			query.append("IS NULL").append(" ");
			
			return this;
		}
		
		public Builder isNotNull() {
			query.append("IS NOT NULL").append(" ");
			
			return this;
		}

		public Builder in() {
			query.append("IN").append(" ");
			
			return this;
		}
		
		public Builder notIn() {
			query.append("NOT IN").append(" ");
			
			return this;
		}
		
		public Builder like() {
			query.append("LIKE").append(" ");
			
			return this;
		}
		
		public Builder notLike() {
			query.append("NOT LIKE").append(" ");
			
			return this;
		}
		
		public Builder betweenAnd(Object first, Object last) {
			query.append("BETWEEN").append(" ").append(first).append(" ").append("AND").append(" ").append(last).append(" ");
			
			return this;
		}

		public Builder condition(String value) {
			if(value.equals("?")) {
				query.append(value + " ");
			} else {
				query.append("'" + value + "' ");
			}
			
			return this;
		}
		
		public Builder condition(int value) {
			query.append(value + " ");
			
			return this;
		}
		
		public Builder condition(double value) {
			query.append(value + " ");
			
			return this;
		}
		
		public Builder condition(List conditionList) {
			
			query.append("(");
			
			for(int i = 0; i < conditionList.size(); i++) {
				if(i != conditionList.size() - 1) {
					query.append(conditionList.get(i)).append(",").append(" ");
				} else {
					query.append(conditionList.get(i));
				}
			}
			
			query.append(")").append(" ");
			
			return this;
			
		}
		
		public Builder prefixPattern(String pattern) {
			query.append(pattern).append(" ").append("|| '%'").append(" ");
			
			return this;
		}
		
		public Builder suffixPattern(String pattern) {
			query.append("'%' ||").append(" ").append(pattern).append(" ");
			
			return this;
		}
		
		public Builder bothPattern(String pattern) {
			query.append("'%' || ").append(pattern).append(" || '%'").append(" ");
			
			return this;
		}
		
		public Builder and() {
			query.append("AND").append(" ");
			
			return this;
		}
		
		public Builder or() {
			query.append("OR").append(" ");
			
			return this;
		}
		
		public Builder groupBy() {
			query.append("GROUP BY").append(" ");
			
			return this;
		}
		
		public Builder having() {
			query.append("HAVING").append(" ");
			
			return this;
		}
		
		public Builder orderBy() {
			query.append("ORDER BY").append(" ");
			
			return this;
		}
		
		public Builder asc() {
			query.append("ASC").append(" ");
			
			return this;
		}
		
		public Builder desc() {
			query.append("DESC").append(" ");
			
			return this;
		}
		
		public Builder enter() {
			query.append("\n");
			
			return this;
		}
		
		public Builder subQuery(SelectQueryMaker subQuery) {
			query.append("(").append(subQuery.getQuery()).append(")");
			
			return this;
		}
		public Builder add(SelectQueryMaker addQuery) {
			query.append(addQuery.getQuery());
			
			return this;
		}
			
		public SelectQueryMaker build() {
			return new SelectQueryMaker(this);
		}
		
		
		
	}
	
	private SelectQueryMaker(Builder builder) {
		this.query = builder.query;
	}
	
	public StringBuilder getQuery() {
		return query;
	}
}
