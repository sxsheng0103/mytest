package com.netboy.netty.handler;
import java.util.Date;
 
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;
 
/**
 * ��������handler
 * TODO
 * Administrator 2013-3-24����03:34:28
 */
public class ServerHandler extends SimpleChannelHandler {
	private static ChannelGroup channelGroup;
 
	/**
	 * ���캯������spring���ص�ʱ���ʼ��һ�Ρ�
	 */
	public ServerHandler() {
		super();
		/*��ÿͻ����ڷ�������ע���������Ϣ�����������пͻ��˷ַ���Ϣ*/
		channelGroup = new DefaultChannelGroup("client-channel-group");
	}
/**
 * ������׽�ͻ����˳�����Ϣ��
 * ������ӷ������˵�ע�����ɾ����
 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
			throws Exception {
		e.getCause().printStackTrace();
		Channel channel = e.getChannel();
		channel.close();
		if (channelGroup.contains(channel)) {
			System.out.println("һ���ͻ����˳���"+channel.getId());
			channelGroup.remove(channel);
		}
	}
/**
 * �ؼ�����
 * ���ڽ��մӿͻ��˷�������Ϣ��������Ӧ���߼�����
 * ������ǽ��κ�һ���ͻ��˷�������Ϣ��������ת�������еĿͻ��ˡ�
 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		String content = (String) e.getMessage();
		System.out.println("�������յ�" + e.getChannel().getId()
				+ " ����Ϣ   ʱ�䣺" + new Date().toString() + " ��Ϣ����:\n"+ content);
		content=e.getChannel().getId()+":"+content;
		if (content.equalsIgnoreCase("quit")) {
			e.getChannel().close();
			channelGroup.remove(e.getChannel());
			return;
		} else {
			System.out.println("��ʼת���������ͻ��ˣ�:size="+channelGroup.size());
			for(Channel ch:channelGroup){
				System.out.println("��ʼת���������ͻ��ˣ�:"+ch.getId());
				ch.write(content);
			}
		}
	}
/**
 * �������ӵ��û�����ע��
 */
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)throws Exception {
		System.out.println("�µĿͻ������룺"+e.getChannel().getId());
		channelGroup.add(e.getChannel());
	}
 
	public  ChannelGroup getChannelGroup() {
		return channelGroup;
	}
}
