package com.Prueba.prueba.domain;

public class Respuesta {

	private String codigo;
	   private String mensaje;
	   private Boolean estado;
	   private Object objResult;
	   
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getMensaje() {
			return mensaje;
		}
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
		public Boolean getEstado() {
			return estado;
		}
		public void setEstado(Boolean estado) {
			this.estado = estado;
		}
		public Object getObjResult() {
			return objResult;
		}
		public void setObjResult(Object objResult) {
			this.objResult = objResult;
		}
		
}
