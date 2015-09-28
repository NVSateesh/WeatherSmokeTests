/*package Test;


    import io.netty.buffer.ByteBuf;
    import io.netty.channel.ChannelHandlerContext;
    import io.netty.handler.codec.http.*;
    import io.netty.util.CharsetUtil;
    import org.littleshoot.proxy.*;
    import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.net.InetSocketAddress;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;

    public class Code {
    	private HttpProxyServer proxyServer;
    	private static final int PROXY_PORT = 9090;  // setting up the proxy server and port
    	private static final String SERVER_IP = "10.50.107.26";
    	private static boolean isVideoCall = false;
    	private List<Map<String, List<String>>> pubadRequests;
    	private String preRollResponse;

//    	/**
//    	* @param args
//    	
    	public HttpProxyServer startServer() {
    		HttpFiltersSource filtersSource = new HttpFiltersSourceAdapter() {
    			@Override
    			public HttpFilters filterRequest(HttpRequest originalRequest, ChannelHandlerContext ctx) {
    			return new HttpFiltersAdapter(originalRequest) {
    				@Override
    				public HttpResponse requestPre(HttpObject httpObject) {
    					if(httpObject instanceof HttpRequest) {
    						HttpRequest request = (HttpRequest) httpObject;
    						if(request.getUri().contains("/gampad/")) {
    							if(request.getMethod() == HttpMethod.GET) {
    								QueryStringDecoder decoder = new QueryStringDecoder(request.getUri());
    								pubadRequests.add(decoder.parameters());
    							}
    							TestNGLogger.logEvent(TestNGLogger.EventType.INFO, "Pubad call was found.");
    							// System.out.println(request.getUri());
    						} else if(request.getUri().contains("onceux")) {
    							isVideoCall = true;
    							if (request.headers().contains("Accept-Encoding")) {
    								request.headers().remove("Accept-Encoding");
    							}
    							TestNGLogger.logEvent(TestNGLogger.EventType.INFO, request.getUri());

    						}
    					}
    					return null;
    				}

    				@Override
    				public HttpObject responsePre(HttpObject httpObject) {
    					if(isVideoCall) {
//    							System.out.println("Response is: " + httpObject);

    						if (httpObject instanceof HttpContent) {
    							String response = ((HttpContent) httpObject)
    									.content().toString(CharsetUtil.UTF_8);

    							if(response.contains("vmap:AdBreak")) {
    								preRollResponse += response;

    								// Temporary for being able to view the response that we are receiving
    								// Will need to replace this with just adding to an Object and then validating against it
//    								File file = new File("C:/Users/tbranstiter/Desktop/responses/response.txt");
    //
//    								try {
//    									FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
//    									BufferedWriter bw = new BufferedWriter(fw);
//    									bw.write(response);
//    									bw.close();
//    								} catch (IOException e) {
//    									e.printStackTrace();
//    								}
    							}

    						}
    					}
    					return httpObject;
    				}
    			};
    			}
    		};

    		System.out.println("Starting proxy on port "+PROXY_PORT + "....");
    		HttpProxyServer proxyServer = DefaultHttpProxyServer.bootstrap()
//    				.withPort(PROXY_PORT)
    				.withAddress(new InetSocketAddress(SERVER_IP, PROXY_PORT))
//                    .withManInTheMiddle(new SelfSignedMitmManager())
    				.withFiltersSource(filtersSource)
    				.start();
    		System.out.println("Proxy server has been started.");

    		return proxyServer;
    	}

    	public static Server getServer() {
    		Server server = new Server();
    		server.proxyServer = server.startServer();
    		server.pubadRequests = new ArrayList<Map<String, List<String>>>();
    		return server;
    	}

    	public HttpProxyServer getProxyServer() {
    		return proxyServer;
    	}

    	public List<Map<String, List<String>>> getRequests() {
    		return pubadRequests;
    	}

    	public String getPreRollResponse() { return preRollResponse; }

    	public HttpObject getResponseData(HttpObject httpObject) {
    		if(httpObject instanceof DefaultHttpResponse) {
    			// HttpVersion v = ((DefaultHttpResponse) httpObject).getProtocolVersion();
    			// HttpResponseStatus s = ((DefaultHttpResponse) httpObject).getStatus();
    			// res = new DefaultFullHttpResponse(v, s);
    		} else if(httpObject instanceof DefaultHttpContent) {
    			ByteBuf bb = ((DefaultHttpContent) httpObject).content();
    			for(int i = 0; i < bb.capacity(); i++) {
    				byte b = bb.getByte(i);
    				System.out.println((char) b);
    			}
    			// res.content().writeBytes(b);
    		} else if(httpObject instanceof DefaultLastHttpContent) {
    			ByteBuf bb = ((DefaultHttpContent) httpObject).content();
    			for(int i = 0; i < bb.capacity(); i++) {
    				byte b = bb.getByte(i);
    				System.out.println((char) b);
    			}
    			// res.content().writeBytes(b);
    			// System.out.println(res);
    			// System.out.println();
    		}
    		return httpObject; 
    	}
    } 

*/