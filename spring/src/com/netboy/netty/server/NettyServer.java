package com.netboy.netty.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
 
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
 
import com.netboy.netty.handler.ServerHandler;
 
public class NettyServer {
	private int port = 8080;
	private ServerBootstrap bootstrap;
	private ServerHandler handler;
/**
 * ��ʼ����������
 */
	public void init() {
		bootstrap = new ServerBootstrap(
				new NioServerSocketChannelFactory(
						Executors.newCachedThreadPool(), //boss �������󣬲����ɸ�slave���д���
				        Executors.newCachedThreadPool()//slave �������󣬽��䶪���̳߳��д���
				                                 ) 
				                         ); 
 
		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			public ChannelPipeline getPipeline() throws Exception {
				ChannelPipeline pipeline = Channels.pipeline();
				/*���͵Ĺ���ʽ����*/
				pipeline.addLast("encode", new StringEncoder());
				pipeline.addLast("decode", new StringDecoder());
				/*����Զ����handler����������д���*/
				pipeline.addLast("handler", handler);
				return pipeline;
			}
		});
		
		/*ʹ��tcp������*/
		bootstrap.setOption("child.tcpNoDelay", true);
		bootstrap.setOption("child.keepAlive", true);
		bootstrap.setOption("reuseAddress", true);
	}
/**
 * �󶨶˿ڣ�����netty����
 */
	public void start() {
		bootstrap.bind(new InetSocketAddress(port));
		System.out.println("����������,�˿�:" + port);
	}
/**
 * �ر�netty���ͷ���Դ��	
 */
	public void stop() {
		bootstrap.releaseExternalResources();
	}
 
	public void setPort(int port) {
		this.port = port;
	}
 
	public void setHandler(ServerHandler handler) {
		this.handler = handler;
	}
 
}
