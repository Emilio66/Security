/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\workspace\\Security\\src\\com\\peerpath\\security\\aidl\\SecurityService.aidl
 */
package com.peerpath.security.aidl;
public interface SecurityService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.peerpath.security.aidl.SecurityService
{
private static final java.lang.String DESCRIPTOR = "com.peerpath.security.aidl.SecurityService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.peerpath.security.aidl.SecurityService interface,
 * generating a proxy if needed.
 */
public static com.peerpath.security.aidl.SecurityService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.peerpath.security.aidl.SecurityService))) {
return ((com.peerpath.security.aidl.SecurityService)iin);
}
return new com.peerpath.security.aidl.SecurityService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_sayHi:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _result = this.sayHi(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.peerpath.security.aidl.SecurityService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String sayHi(java.lang.String someone) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(someone);
mRemote.transact(Stub.TRANSACTION_sayHi, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_sayHi = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.lang.String sayHi(java.lang.String someone) throws android.os.RemoteException;
}
