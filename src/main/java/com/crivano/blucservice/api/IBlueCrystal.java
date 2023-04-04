package com.crivano.blucservice.api;

import java.util.Date;

import com.crivano.swaggerservlet.ISwaggerMethod;
import com.crivano.swaggerservlet.ISwaggerModel;
import com.crivano.swaggerservlet.ISwaggerRequest;
import com.crivano.swaggerservlet.ISwaggerResponse;

public interface IBlueCrystal {
	public static class CertDetails implements ISwaggerModel {
		public String aki0;
		public String basicConstraint0;
		public String birth_date0;
		public String certPolOid0;
		public String certPolQualifier0;
		public String certSha2560;
		public String cert_type0;
		public String cert_usage0;
		public String chain0;
		public String cpf0;
		public String crlDP0;
		public String eku0;
		public String eleitor0;
		public String issuer0;
		public String key_length0;
		public String ku0;
		public String notAfter0;
		public String notBefore0;
		public String ocsp0;
		public String rg0;
		public String rg_org0;
		public String rg_uf0;
		public String san_email0;
		public String serial0;
		public String subject0;
		public String version0;
		public String thumbprint_sha2560;
		public String pis0;
		public String inss0;
		public String cnpj0;
		public String person_name0;
		public String professional0;
	}

	public static class Policy implements ISwaggerModel {
	}

	public static class PolicyVersion implements ISwaggerModel {
	}

	public static class PolicyOID implements ISwaggerModel {
	}

	public static class CN implements ISwaggerModel {
	}

	public static class HashB64 implements ISwaggerModel {
	}

	public static class EnvelopeB64 implements ISwaggerModel {
	}

	public static class Status implements ISwaggerModel {
	}

	public static class Message implements ISwaggerModel {
	}

	public static class Sha256Hex implements ISwaggerModel {
	}

	public static class Error implements ISwaggerModel {
		public String errormsg;
	}

	public interface ICertificatePost extends ISwaggerMethod {
		
		public class Request implements ISwaggerRequest {
			public byte[] certificate;
		}

		public class Response implements ISwaggerResponse {
			public String cn;
			public String name;
			public String subject;
			public String cpf;
			public CertDetails certdetails;
		}
		
		public void run(Request req, Response resp, BlueCrystalContext ctx) throws Exception;
	}

	public interface IAttachPost extends ISwaggerMethod {
		
		public class Request implements ISwaggerRequest {
			public byte[] envelope;
			public byte[] content;
			public Date time;
			public Boolean crl;
		}

		public class Response implements ISwaggerResponse {
			public byte[] envelope;
			public String sha256hex;
		}
		
		public void run(Request req, Response resp, BlueCrystalContext ctx) throws Exception;
	}

	public interface IHashPost extends ISwaggerMethod {
		
		public class Request implements ISwaggerRequest {
			public String policy;
			public byte[] certificate;
			public byte[] sha1;
			public byte[] sha256;
			public Date time;
			public Boolean crl;
		}

		public class Response implements ISwaggerResponse {
			public byte[] hash;
			public String policy;
			public String policyversion;
			public String policyoid;
			public String cn;
			public CertDetails certdetails;
		}

		
		public void run(Request req, Response resp, BlueCrystalContext ctx) throws Exception;
	}

	public interface IEnvelopePost extends ISwaggerMethod {
		
		public class Request implements ISwaggerRequest {
			public byte[] signature;
			public String policy;
			public byte[] certificate;
			public byte[] sha1;
			public byte[] sha256;
			public Date time;
			public Boolean crl;
		}

		public class Response implements ISwaggerResponse {
			public byte[] envelope;
			public String policy;
			public String policyversion;
			public String policyoid;
			public String cn;
			public CertDetails certdetails;
		}
		
		public void run(Request req, Response resp, BlueCrystalContext ctx) throws Exception;
	}


	public interface IValidatePost extends ISwaggerMethod {
		
		public class Request implements ISwaggerRequest {
			public byte[] envelope;
			public byte[] sha1;
			public byte[] sha256;
			public Date time;
			public Boolean crl;
		}

		public class Response implements ISwaggerResponse {
			public String policy;
			public String policyversion;
			public String policyoid;
			public String cn;
			public CertDetails certdetails;
			public String status;
			public String errormsg;
		}
		
		public void run(Request req, Response resp, BlueCrystalContext ctx) throws Exception;
	}

}